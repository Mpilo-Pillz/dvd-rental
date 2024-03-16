package org.example;

import com.sun.net.httpserver.HttpServer;
import org.example.handlers.GreetHandler;
import org.example.handlers.QueryDbHandler;
import org.example.handlers.crud.CreateHandler;
import org.example.handlers.crud.ReadHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
public class Main {
    public static void main(String[] args) throws IOException {
        int serverPort = 8200;
        InetSocketAddress inetSocketAddress = new InetSocketAddress(serverPort);
        HttpServer server = HttpServer.create(inetSocketAddress, 0);

        // server Contexts
        server.createContext("/greet", new GreetHandler());
        server.createContext("/querydb", new QueryDbHandler());

        server.createContext("/create", new CreateHandler()); //TODO pherhaps injectt he sql query
        server.createContext("/read", new ReadHandler());

        // Start the server
        server.start();
        System.out.println("Server is listening on port " + serverPort);
    }
}