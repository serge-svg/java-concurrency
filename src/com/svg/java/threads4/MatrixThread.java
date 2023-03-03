package com.svg.java.threads4;

import java.util.Random;
/*
 In this example each available processor in the computer will do its part of the job
 */

public class MatrixThread extends Thread {

    private static final int ELEMENTS = 15;
    private static final int PROCESSORS  = Runtime.getRuntime().availableProcessors();
    private static final int RANGE = ELEMENTS / PROCESSORS;
    private static final long[][] vectorWithOutConcurrency = new long[ELEMENTS][ELEMENTS];
    private static final long[][] vectorWithConcurrency = new long[ELEMENTS][ELEMENTS];

    private final int firstIndex, lastIndex;

    public MatrixThread(int firstIndex, int lastIndex) {
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
    }

    public static void main(String[] args) throws InterruptedException {
        doWorkWithOutConcurrency();
        //printVector(vectorWithOutConcurrency);

        doWorkWithConcurrency();
        //printVector(vectorWithConcurrency);
    }

    private static void printVector(long[][] vector) {
        for (int row = 0; row < ELEMENTS; row++) {
            for (int column = 0; column < ELEMENTS; column++) {
                System.out.print(vector[row][column] + " ");
            }
            System.out.println();
        }
    }

    public void run() {
        System.out.printf("%s range from %d to %d%n", Thread.currentThread().getName(), firstIndex, lastIndex );
        Random rand = new Random(1000);
        for (int row = firstIndex; row < lastIndex; row++) {
            for (int column = 0; column < ELEMENTS; column++) {
                vectorWithConcurrency[row][column] = rand.nextInt();
                vectorWithConcurrency[row][column] *= 10;
                vectorWithConcurrency[row][column] /= 10;
                vectorWithConcurrency[row][column] += 10;
                vectorWithConcurrency[row][column] -= 10;
            }
        }
    }

    private static void doWorkWithConcurrency() throws InterruptedException {
        long time  = System.nanoTime();

        Thread[] vectorOfThreads = new Thread[PROCESSORS];
        int init, end = 0;

        for (int i = 0; i < PROCESSORS; i++) {
            init = end;
            if (i != PROCESSORS - 1)
                end += RANGE;
            else
                end = ELEMENTS;

            vectorOfThreads[i] = new MatrixThread(init, end);
            vectorOfThreads[i].start();
        }

        for (int i = 0; i < PROCESSORS; i++) {
            vectorOfThreads[i].join();
        }
        System.out.printf("Version with concurrency needed time was: %d %s %n", (System.nanoTime() - time), " nanoseconds");
    }

    private static void doWorkWithOutConcurrency() {
        long time = System.nanoTime();

        System.out.println("\nThread..." + Thread.currentThread().getName() );
        Random rand = new Random(1000);
        for (int row = 0; row < ELEMENTS; row++) {
            for (int column = 0; column < ELEMENTS; column++) {
                vectorWithOutConcurrency[row][column] = rand.nextInt();
                vectorWithOutConcurrency[row][column] *= 10;
                vectorWithOutConcurrency[row][column] /= 10;
                vectorWithOutConcurrency[row][column] += 10;
                vectorWithOutConcurrency[row][column] -= 10;
            }
        }
        printVector(vectorWithOutConcurrency);
        System.out.printf("Version without concurrency needed time was: %d %s %n", (System.nanoTime() - time), " nanoseconds");
    }

}
