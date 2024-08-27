package com.company.designpatternsV2.singleton;

/**
 * Static block initialization implementation is similar to eager initialization,
 * except that instance of the class is created in the static block that provides the option for exception handling.
 * Both eager initialization and static block initialization create the instance even before it’s being used and that is not the best practice to use.
 */
public class StaticBlockSingleton {
    private static StaticBlockSingleton instance;

    private StaticBlockSingleton() {
    }

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Error initializing static block singleton");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
