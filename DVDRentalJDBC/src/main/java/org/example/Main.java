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
//            simpleDeleteWithExcecuteUpdate(connection);
//                        simpleUpdateWithExcecuteUpdate(connection);
//                        simpleReadWithExecuteQuery(connection);
//            simpleInsertWithExcecuteUpdate(connection);
//            simpleReadWithExecute(connection);
//            simpleInsertWithParameterizedExcecuteUpdate(connection);
            simpleReadWithParameterizedExecuteQuery(connection);
        } catch (SQLException e) {
    throw new RuntimeException(e);
        }
    }



    // DELETE
    private static void simpleDeleteWithExcecuteUpdate(Connection connection) throws SQLException {
        String sql = "DELETE FROM country where country='Wakanda'"; // will delete al occurences

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        int result = preparedStatement.executeUpdate();

        if (result > 0) {
            System.out.println("Update database");
        } else {
            System.out.println("No update");
        }
    }

    // UPDATE
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

    // CREATE
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

    // READ
    private static void simpleReadWithExecuteQuery(Connection connection) throws SQLException {
        String sql = "select first_name, email from customer";

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            System.out.println(".");
        }
        System.out.println();
    }

    // Excecute
    // Returns a boolean for if there is a result set or not
    private static void simpleReadWithExecute(Connection connection) throws SQLException {
        String sql = "select actor_id, first_name, last_name from actor";

        var statement = connection.prepareStatement(sql);

        var result = statement.execute();

        if (result) {
            var resultSet = statement.getResultSet();
            while(resultSet.next()) {
                System.out.println("." + resultSet);
            }
            System.out.println();
        }

    }

/*
* PARAMETERIZING
* */
// CREATE
private static void simpleInsertWithParameterizedExcecuteUpdate(Connection connection) throws SQLException {
//    String sql = "INSERT INTO actors (first_name, last_name) VALUES (?, ?)";
    String sql = "INSERT INTO city (city, country_id) VALUES (?, ?)";

    var preparedStatement = connection.prepareStatement(sql);

    preparedStatement.setString(1, "Mbabane");
    preparedStatement.setInt(2, 111);

    int result = preparedStatement.executeUpdate();

    if (result > 0) {
        System.out.println("Update database");
    } else {
        System.out.println("No update");
    }
}

    // READ SELECT
    private static void simpleReadWithParameterizedExecuteQuery(Connection connection) throws SQLException {
        String sql = "select first_name, last_name from actor where last_name like ?";

        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, "%ashingto%"); // has no data
        statement.setString(1, "%ag%");

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            System.out.println(".");
        }
        System.out.println();
    }
}