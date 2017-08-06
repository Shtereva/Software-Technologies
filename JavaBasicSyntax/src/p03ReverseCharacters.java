import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p03ReverseCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = new String[3];

        for (int i = 0; i < arr.length; i++) {
            String input = scanner.nextLine();
            arr[i] = input;
        }

        Collections.reverse(Arrays.asList(arr));
        System.out.println(String.join("", arr));
    }

}
