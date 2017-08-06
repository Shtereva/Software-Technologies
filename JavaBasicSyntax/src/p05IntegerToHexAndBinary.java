import java.util.Scanner;

public class p05IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(Integer.toHexString(Integer.parseInt(input)).toUpperCase());
        System.out.println(Integer.toBinaryString(Integer.parseInt(input)));
    }

}
