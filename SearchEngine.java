import java.io.IOException;
import java.net.URI;
import java.util.*;

class SearchHandler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    private HashSet<String> set = new HashSet<>();

    public String handleRequest(URI url) {
        String[] parameters = url.getQuery().split("=");
        System.out.println(parameters[0]);
        if (url.getPath().equals("/add")) {
            if (parameters[0].equals("s")) {   
                set.add(parameters[1]); 
                return String.format("Word added!");
            }
        } else if (url.getPath().equals("/search")){
            if (parameters[0].equals("s")) {   
                StringBuilder ret = new StringBuilder();
                for (String cmp : set) {
                    if (cmp.contains(parameters[1])) ret.append(cmp + " ");
                }
                return ret.toString();
            }
        } 
        return "404 Not Found!";
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new SearchHandler());
    }
}
