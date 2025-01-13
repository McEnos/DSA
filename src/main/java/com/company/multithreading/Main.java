package com.company.multithreading;

public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        Thread runnable = new Thread(new MyRunnable());
        runnable.start();
    }
}
