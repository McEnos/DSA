package com.company.designpatternsV2.singleton;

/**
 * In eager initialization, the instance of the singleton class is created at the time of class loading.
 * The drawback to eager initialization is that the method is created even though the client application might not be using it
 * <p>
 * If your singleton class is not using a lot of resources, this is the approach to use.
 * But in most of the scenarios, singleton classes are created for resources such as File System, Database connections, etc
 */
public class EagerInitializedSingleton {
    private static EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {
    }

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}
