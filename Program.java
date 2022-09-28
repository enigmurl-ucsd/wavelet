import java.io.IOException;

class Handler implements URLHandler {
    // the num to be modified
    int num = 0;

    public String handleRequest(String url) {
        System.out.println(url);
        if (url.equals("/")) {
            return String.format("Number: %d", num);
        } else if (url.equals("/increment")) {
            num += 1;
            return String.format("Number incremented!");
        } else {
            if (url.contains("/add?")) {
                int indexOfQ = url.indexOf("?");
                String[] parameters = url.substring(indexOfQ + 1).split("=");
                if (parameters[0].equals("count")) {
                    num += Integer.parseInt(parameters[1]);
                    return String.format("Number increased by %s! It's now %d", parameters[1], num);
                }
            }
            return "404 Not Found!";
        }
    }
}

class Main {
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

        Server.start(port, new Handler());
    }
}
