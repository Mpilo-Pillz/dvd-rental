package org.example.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

import static org.example.utils.HttpHelper.sendResponse;

public class GreetHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "Hey Mpillz, the Server is working";
        sendResponse(httpExchange, response, 200);
    }
}
