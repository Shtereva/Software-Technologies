import java.util.Scanner;

public class p04VowelOrDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String vowels = "aeuioy";
        String input = scanner.nextLine();
        if (Character.isDigit(input.charAt(0))) {
            System.out.println("digit");
        } else if (vowels.contains(input)) {
            System.out.println("vowel");
        } else {
            System.out.println("other");
        }
    }
}
