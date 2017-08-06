import java.util.Arrays;
import java.util.Scanner;

public class ThreeIntegersSum {
    public static void main(String[] arg) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        int num1 = arr[0];
        int num2 = arr[1];
        int num3 = arr[2];

        if (num1 + num2 == num3){
            System.out.printf("%d + %d = %d%n", Math.min(num1, num2), Math.max(num1, num2), num1 + num2);
        }

        else if (num2 + num3 == num1){
            System.out.printf("%d + %d = %d%n", Math.min(num2, num3), Math.max(num2, num3), num2 + num3);
        }
        else if (num3 + num1 == num2){
            System.out.printf("%d + %d = %d%n", Math.min(num3, num1), Math.max(num3, num1), num3 + num1);
        }
        else {
            System.out.println("No");
        }
    }
}
