import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p17ChangeToUppercase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("<upcase>(.+?)<\\/upcase>");

        Matcher matcher = pattern.matcher(text);


        while (matcher.find()){
            String temp = matcher.group(1).toUpperCase();
            text = text.replace(matcher.group(0), temp);
        }

        System.out.println(text);
    }

}
