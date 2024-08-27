package com.company.designpatternsV2.singleton;

/**
 * Ensures a class has only one instance and provides a global point to access it
 * A class cannot have multiple instances, once created, the next time onward, you use existing instance
 * Helps unnecessary object creations
 * Promotes easy maintenance
 * <p>
 * private constructor ensures Captain class cannot be extended,So, subclasses cannot misuse the concept
 * private constructor ensures that singleton class(Captain) cannot be instantiated outside
 * <a href="https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples#2-static-block-initialization">DigitalOcean</a>
 */
final public class Captain {
    /**
     * Implementation
     * <p>
     * 1. Private constructor to restrict instantiation of the class from other classes.
     * 2. Private static variable of the same class that is the only instance of the class.
     * 3. Public static method that returns the instance of the class, this is the global access point for the outer world to get the instance of the singleton class.
     */
    private static Captain captain;
    private int numberOfInstances = 0;

    private Captain() {
        numberOfInstances++;
        System.out.println("Number of instances: " + numberOfInstances);
    }

    /**
     * uses the “synchronized” keyword. So, multiple threads cannot
     * involve in the instantiation process at the same time. I am forcing
     * each thread to wait its turn to get the method, so thread-safety is
     * ensured
     *
     */

    public static synchronized Captain getCaptain() {
        if (captain == null) {
            captain = new Captain();
            System.out.println("New captain is elected for your team");
        } else {
            System.out.println("You already have a captain for your team");
            System.out.println("Send him for the toss");
        }
        return captain;
    }
}
