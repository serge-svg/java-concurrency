package com.svg.java.threads1.d.extends_thread_join;
/*
 In this example task B ends before task A begins thanks to join() method
 */
public class Main {
    // Main thread
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Application starts");

        MyTask myTask = new MyTask();
        myTask.start();
        myTask.join();

        for (int i = 1; i <= 10; i++) {
            System.out.println("Task type A: " + i);
        }

        System.out.println("Application ends");
    }
}

