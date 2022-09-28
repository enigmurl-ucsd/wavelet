//referenced and modified from
//https://dzone.com/articles/simple-http-server-in-java

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

interface URLHandler {
    String handleRequest(String url);
}

//Hosts a simple server and handles all the requests in Program class
//DO NOT CHANGE THIS METHOD
public class Server {
    public static void start(int port, URLHandler handler) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        //create request entrypoint
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(final HttpExchange exchange) throws IOException {
                
                
                // form return body after being handled by program
                String ret = handler.handleRequest(exchange.getRequestURI().toString());

                //form the return string and write it on the browser
                exchange.sendResponseHeaders(200, ret.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(ret.getBytes());
                os.close();
            }
        });

        //start the server
        server.start();
        System.out.println("Server Started! Visit http://localhost:" + port + " to visit.");
    }
}
