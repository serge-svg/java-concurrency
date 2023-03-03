package com.svg.java.threads1.c.implements_runnable;

class MyTask implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Task type B: " + i);
        }
    }
}
