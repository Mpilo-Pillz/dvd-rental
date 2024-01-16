package org.example;

import java.sql.*;

public class Main {
//    public static void main(String[] args) {
//
//        try (
//                Connection connection = DriverManager.getConnection(Application.url, Application.userName, Application.password);
//                PreparedStatement statement = connection.prepareStatement("SELECT * from Customer");
//                ) {
////            System.out.println(connection);
//
//            ResultSet resultSet = statement.executeQuery();
//
//            while(resultSet.next()) {
//                System.out.println(resultSet.getString("last_name"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(Application.url, Application.userName, Application.password)) {
            simpleDeleteWithExcecuteUpdate(connection);
//                        simpleUpdateWithExcecuteUpdate(connection);
//                        simpleReadWithExecuteQuery(connection);
//            simpleInsertWithExcecuteUpdate(connection);
        } catch (SQLException e) {

        }
    }

    private static void simpleDeleteWithExcecuteUpdate(Connection connection) throws SQLException {
        String sql = "DELETE FROM country where country='Wakanda'";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        int result = preparedStatement.executeUpdate();

        if (result > 0) {
            System.out.println("Update database");
        } else {
            System.out.println("No update");
        }
    }
    private static void simpleUpdateWithExcecuteUpdate(Connection connection) throws SQLException {
        String sql = "UPDATE \"country\" SET \"country\" = 'Eswatini / Swaziland' WHERE \"country\" = 'Eswatini'";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        int result = preparedStatement.executeUpdate();

        if (result > 0) {
            System.out.println("Update database");
        } else {
            System.out.println("No update");
        }
    }

    private static void simpleInsertWithExcecuteUpdate(Connection connection) throws SQLException {
        String sql = "INSERT INTO country (country) VALUES ('Wakanda')";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        int result = preparedStatement.executeUpdate();

        if (result > 0) {
            System.out.println("Update database");
        } else {
            System.out.println("No update");
        }
    }
    private static void simpleReadWithExecuteQuery(Connection connection) throws SQLException {
        String sql = "select first_name, email from customer";

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            System.out.println(".");
        }
        System.out.println();
    }
}