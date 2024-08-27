package com.company.designpatterns.creational.singleton;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    private static class DatabaseConnectionHelper {
        private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    }

    public static DatabaseConnection getInstance() {
        return DatabaseConnectionHelper.INSTANCE;
    }

    private DatabaseConnection() {

    }
}
