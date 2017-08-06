import java.io.BufferedReader;
import java.util.Scanner;

public class p16URLParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String protocol = "";
        String server = "";
        String resource = "\"\"";

        String[] firstPart = text.split("://");
        if (firstPart.length > 1) {
            protocol = firstPart[0];
            text = text.substring(protocol.length() + 3 );
        }

        String[] secondPart = text.split("/");

        if (secondPart.length > 1) {
            server = "\"" + secondPart[0] + "\"";
            resource = "\"" + text.substring(server.length() - 1) + "\"";
        }else {
            server = "\"" + secondPart[0] + "\"";
        }

        System.out.println("[protocol] = " + "\"" + protocol + "\"");
        System.out.println("[server] = " + server);
        System.out.println("[resource] = " + resource);

    }

}
