package com.svg.java.threads0;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.printf("%s is running %n", Thread.currentThread().getName() );
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
        System.out.printf("%s has been created %n", t1.getName());

        Thread t2 = new Thread(new MyRunnable());
        t2.start();
        System.out.printf("%s has been created %n", t1.getName());

        t1.join();
        t2.join();
        System.out.println("Thread..." + Thread.currentThread().getName() );
    }

}
