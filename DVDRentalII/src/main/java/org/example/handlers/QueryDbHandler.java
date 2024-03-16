package org.example.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.Application;
import org.example.db.DatabaseConfig;
import org.example.utils.HttpHelper;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QueryDbHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String responseText = "";
        try {
            Connection connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Application.url, Application.userName, Application.password)) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String response = responseText;
        HttpHelper.sendResponse(exchange, response, 200);
    }
}


//  server.createContext("/querydb", new HttpHandler() {
//    @Override
//    public void handle(HttpExchange exchange) throws IOException {
//        String responseText = "";
//        try (Connection connection = DriverManager.getConnection(Application.url, Application.userName, Application.password)) {
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
////                String response = "Spoke to DB Successfully";
//        String response = responseText;
//        exchange.sendResponseHeaders(200, response.getBytes().length);
//        OutputStream os = exchange.getResponseBody();
//        os.write(response.getBytes());
//        os.close();
//    }
//});
