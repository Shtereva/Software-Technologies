
import java.util.Scanner;

public class p13ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] text = scanner.nextLine().toCharArray();
        String reverse = new StringBuilder(new String(text)).reverse().toString();
        System.out.println(String.join("", reverse));
    }

}
