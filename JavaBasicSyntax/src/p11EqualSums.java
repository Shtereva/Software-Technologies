import java.util.Arrays;
import java.util.Scanner;

public class p11EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean hasMatch = false;
        int output = 0;

        for (int i = 0; i < array.length; i++) {
            int right = 0;
            int left = 0;

            for(int rightSum = i - 1; rightSum >= 0; rightSum--){
                right += array[rightSum];
            }

            for(int leftSum = i + 1; leftSum < array.length; leftSum++){
                left += array[leftSum];
            }

            if (right == left) {
                hasMatch = true;
                output = i;
                break;
            }
        }

        System.out.println(hasMatch ? output : "no");
    }

}
