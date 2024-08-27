package com.company.designpatternsV2.singleton;

/**
 * implementation works fine in the case of the single-threaded environment, but when it comes to multithreaded systems
 * It will destroy the singleton pattern and both threads will get different instances of the singleton class
 */
public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {

    }

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
