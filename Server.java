//referenced and modified from
//https://dzone.com/articles/simple-http-server-in-java

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

//Hosts a simple server and handles all the requests in Program class
//DO NOT CHANGE THIS METHOD
public class Server {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        if(args[0].equals("22")){
            System.out.println("Did you know that port 22 is the one used by ssh? We can't use it for a web server.");
            return;
        }

        int port = Integer.parseInt(args[0]);
        
        //create server
        HttpServer server = HttpServer.create(new InetSocketAddress(port),
                0);

        //initialize program
        Program program = new Program();
        //create request entrypoint
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(final HttpExchange exchange) throws IOException {
                
                
                //form return body after being handled by program
                String ret = "<html>" + program.handleRequest(
                        exchange.getRequestURI().toString()) + "</html>";

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
