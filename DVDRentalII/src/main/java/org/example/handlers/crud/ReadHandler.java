package org.example.handlers.crud;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.db.DatabaseConfig;
import org.example.handlers.DatabaseOperation;
import org.example.utils.HttpHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadHandler implements HttpHandler, DatabaseOperation {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        execute(exchange);
    }
    @Override
    public void execute(HttpExchange exchange) throws IOException {
        String sql = "SELECT * FROM my_table";

        StringBuilder responseText = new StringBuilder();
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql); // TODO I see i type this alot
             ResultSet resultSet = statement.executeQuery()) {

            while(resultSet.next()) {
                String column1 = resultSet.getString("First Column");
                int column2 = resultSet.getInt("Second Cilumn");
                responseText.append(column2).append(",").append(column1).append("\n");
            }

            HttpHelper.sendResponse(exchange, responseText.toString(), 200);
        } catch (Exception e) {
            HttpHelper.sendResponse(exchange, "Database error: " + e.getMessage(), 500);
            e.printStackTrace();
        }

    }


}
