import java.util.Scanner;

public class p10IndexOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] letters = new char[26];
        int index = 0;

        for (char i = 'a'; i <= 'z'; i++) {
            letters[index] = i;
            index++;
        }
        char[] input = scanner.nextLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                if (input[i] == letters[j]) {
                    System.out.println(input[i] + " -> " + j);
                }

            }

        }
    }

}
