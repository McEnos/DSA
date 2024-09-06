package com.company.designpatterns.creational.singleton;

/**
 * The preferred method of creating singleton design
 * # Bill Pugh Singleton implementation
 *  1) Private constructor to restrict instantiation from other classes.
 *  2) Public static method that returns the instance of class(this is the global access point
 *  that can be called by other classes to get an instance of the class.
 *  3)
 */
public class DatabaseConnection {
    private DatabaseConnection() {

    }

    private static class DatabaseConnectionHelper {
        private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    }

    public static DatabaseConnection getInstance() {
        return DatabaseConnectionHelper.INSTANCE;
    }


}
