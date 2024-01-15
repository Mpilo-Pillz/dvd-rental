package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try (
                Connection connection = DriverManager.getConnection(Application.url, Application.userName, Application.password);
                PreparedStatement statement = connection.prepareStatement("SELECT * from Customer");
                ) {
//            System.out.println(connection);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                System.out.println(resultSet.getString("last_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}