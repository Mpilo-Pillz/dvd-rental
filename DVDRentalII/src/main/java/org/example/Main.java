package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.example.handlers.GreetHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException {
        int serverPort = 8200;
        InetSocketAddress inetSocketAddress = new InetSocketAddress(serverPort);
        HttpServer server = HttpServer.create(inetSocketAddress, 0);

        // server Contexts

        server.createContext("/greet", new GreetHandler());

        server.createContext("/querydb", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String responseText = "";
                try (Connection connection = DriverManager.getConnection(Application.url, Application.userName, Application.password)) {

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
        System.out.println("Server is listening on port " + serverPort);
    }
}