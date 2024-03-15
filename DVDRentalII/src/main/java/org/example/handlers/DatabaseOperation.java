package org.example.handlers;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public interface DatabaseOperation {
    void execute(HttpExchange exchange) throws IOException;
}
