package org.example;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.*;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

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

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/greet", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String response = "Hello, World!";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        server.createContext("/querydb", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String responseText = "";
                try (Connection connection = DriverManager.getConnection(Application.url, Application.userName, Application.password)) {
//            simpleDeleteWithExcecuteUpdate(connection);
//                        simpleUpdateWithExcecuteUpdate(connection);
//                        simpleReadWithExecuteQuery(connection);
//            simpleInsertWithExcecuteUpdate(connection);
//            simpleReadWithExecute(connection);
//            simpleInsertWithParameterizedExcecuteUpdate(connection);
            responseText = simpleReadWithParameterizedExecuteQuery(connection);
//                      simpleReadWithParameterizedExecuteQueryAnCountIndex(connection);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
//                String response = "Spoke to DB Successfully";
                String response = responseText;
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        // Start the server
        server.start();
        System.out.println("Server is listening on port 8000");

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

        while (resultSet.next()) {
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
            while (resultSet.next()) {
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
    private static String simpleReadWithParameterizedExecuteQuery(Connection connection) throws SQLException {
        String responseString = "";
        String sql = "select first_name, last_name from actor where last_name like ?";

        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, "%ashingto%"); // has no data
        statement.setString(1, "%ag%");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
//            String first_name = resultSet.getString(1);
//            String last_name = resultSet.getString(2);
            //            System.out.println(first_name + " " + last_name + " is in the db order matters");

            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
//            int last_name = resultSet.getInt(2);


            System.out.println(firstName + " " + lastName + " is in the db");
            responseString += firstName + " " + lastName + " is in the db, ";
        }
        return responseString;
    }

    // READ SELECT
    private static void simpleReadWithParameterizedExecuteQueryAnCountIndex(Connection connection) throws SQLException {
        String sql = "select count(*) as count from staff";

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
//            int last_name = resultSet.getInt(2);
            System.out.println("The number of staff employed is " + resultSet.getInt("count"));
        }
        System.out.println();
    }
}