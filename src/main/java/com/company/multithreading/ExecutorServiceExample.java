package com.company.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            final int taskNumber = i;
            executorService.execute(() -> System.out.println("Task" + taskNumber + " executed by thread " + Thread.currentThread().getName()));
        }
        executorService.shutdown();
    }
}
