package com.svg.java.threads1.d.extends_thread_join;

class MyTask extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Task type B: " + i);
        }
    }
}
