package com.svg.java.threads1.b.extends_thread;
/*
 In this example task A and B work mixed without preference control
*/
public class Main {
    // Main thread
    public static void main(String[] args) {
        System.out.println("Application starts");

        MyTask myTask = new MyTask();
        myTask.start();

        for (int i = 1; i <= 10; i++) {
            System.out.println("Task type A: " + i);
        }

        System.out.println("Application ends");
    }
}

