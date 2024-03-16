package org.example.handlers.crud;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.db.DatabaseConfig;
import org.example.handlers.DatabaseOperation;
import org.example.utils.HttpHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreateHandler implements HttpHandler, DatabaseOperation {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        execute(exchange);
    }

    @Override
    public void execute(HttpExchange exchange) throws IOException {
        String sql = "INSERT INTO my_table (column1, column2) VALUES (?, ?)"; // TODO find a way to read from outside
//      TODO See if I can Resuse QueryDbHandler
        try (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "valueArg");
            statement.setInt(2, 123);
            int result = statement.executeUpdate();
        } catch (Exception e) {
            HttpHelper.sendResponse(exchange, "Database error: " + e.getMessage(), 500 );
            e.printStackTrace();
        }
    }
}
