package com.svg.java.threads0;

public class MyThread extends Thread {

    public void run() {
        System.out.printf("%s is running %n", Thread.currentThread().getName() );
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyThread();
        t1.start();
        System.out.printf("%s has been created %n", t1.getName());

        Thread t2 = new MyThread();
        t2.start();
        System.out.printf("%s has been created %n", t2.getName());

        t1.join();
        t2.join();

        System.out.println("Thread..." + Thread.currentThread().getName() );

    }
}
