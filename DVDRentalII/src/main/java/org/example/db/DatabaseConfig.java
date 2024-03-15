package org.example.db;

import org.example.Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(Application.url, Application.userName, Application.password);
            } catch (SQLException e) {
                System.err.println("Database connection error: " + e.getMessage());
                throw e;
            }
        }
        return connection;
    }
}
