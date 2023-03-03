package com.svg.java.threads1.a.nothread;

class MyTask {
    void execute() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Task type B: " + i);
        }
    }
}
