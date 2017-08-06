import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SymmetricNumbers {
    public static void main(String[] arg) {
        Scanner console = new Scanner(System.in);
        int num = Integer.parseInt(console.nextLine());

        for (int i = 1; i <= num; i++){
            String[] temp = Integer.toString(i).split("");
            Collections.reverse(Arrays.asList(temp));
            int reversed = Integer.parseInt(String.join("", temp));
            if (i == reversed){
                System.out.print(i + " ");
            }
        }
    }
}
