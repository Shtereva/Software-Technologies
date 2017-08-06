
import java.util.Scanner;

public class p15CensorEmailAddress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] email = scanner.nextLine().split("@");
        String text = scanner.nextLine();

        String domain = email[1];
        String username = new String(new char[email[0].length()]).replace("\0", "*") + "@" + domain;

        String pattern = email[0] + "@" + email[1];
        String result = text.replaceAll(pattern, username);

        System.out.println(result);
    }

}
