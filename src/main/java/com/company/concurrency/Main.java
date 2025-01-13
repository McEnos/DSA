package com.company.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args){
        AtomicLong atomicLong = new AtomicLong();
        AtomicInteger atomicInteger = new AtomicInteger();

        synchronized (atomicLong){
            atomicLong.incrementAndGet();
        }
    }
}
