import java.util.Arrays;
import java.util.Scanner;


public class LargestThreeNumbers {
    public static void main(String[] arg) {
        Scanner console = new Scanner(System.in);

        String[] line = console.nextLine().split(" ");
        int[] result = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(result);

        for (int i = result.length - 1; i >= Math.max(result.length - 3, 0); i--){
            System.out.println(result[i]);
        }

    }
}
