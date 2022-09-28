import java.util.regex.Pattern;

public class Program {
    // the num to be modified
    int num = 0;

    // DO NOT CHANGE THIS HEADER
    public String handleRequest(String url) {
        System.out.println(url);
        if (url.equals("/")) {
            return String.format("Number: %d", num);
        } else if (url.equals("/increment")) {
            num += 1;
            return String.format("Number incremented!");
        } else {
            if (url.contains("/add?")) {
                String[] parameter = url.split(Pattern.quote("?"))[1].split("=");
                if (parameter[0].equals("count")) {
                    num += Integer.parseInt(parameter[1]);
                    return String.format("Number increased by %s!", parameter[1]);
                }
            }
            return "<b>404 Not Found!</b>";
        }
    }
}