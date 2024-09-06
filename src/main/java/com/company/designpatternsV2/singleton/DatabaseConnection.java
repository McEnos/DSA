package com.company.designpatternsV2.singleton;

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
