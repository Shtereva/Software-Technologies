

import java.util.Scanner;

public class p14FitStringIn20Chars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.length() < 20) {
            System.out.println(input + new String(new char[Math.abs(20 - input.length())]).replace("\0", "*"));
        }else {
            System.out.println(input.substring(0, 20));
        }
    }

}
