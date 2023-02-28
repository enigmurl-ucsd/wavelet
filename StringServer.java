import java.io.IOException;
import java.net.URI;
import java.util.*;

class StringHandler implements URLHandler {
    private String running = ""; 

    public String handleRequest(URI url) {
        if (url.getPath().equals("/add-message") && url.getQuery() != null) {
            String[] parameters = url.getQuery().split("=");
            if (parameters != null && parameters.length >= 2 && parameters[0].equals("s")) {   
                running += parameters[1] + '\n'; 
                return running;
            }
        } 
        return "404 Not Found or malformed input query!";
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new StringHandler());
    }
}
