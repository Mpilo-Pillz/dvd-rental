package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.example.handlers.GreetHandler;
import org.example.handlers.QueryDbHandler;

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
        server.createContext("/querydb", new QueryDbHandler());

        // Start the server
        server.start();
        System.out.println("Server is listening on port " + serverPort);
    }
}