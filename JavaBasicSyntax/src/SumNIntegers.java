import java.util.Scanner;

public class SumNIntegers {
    public static void main(String[] arg) {
        Scanner console = new Scanner(System.in);
        int num = Integer.parseInt(console.nextLine());
        long result = 0;
        for (int i = 0; i < num; i++){
            result += Integer.parseInt(console.nextLine());
        }

        System.out.println("Sum = " + result);
    }
}
