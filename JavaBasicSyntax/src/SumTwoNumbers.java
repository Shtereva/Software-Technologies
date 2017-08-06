import java.util.Scanner;

public class SumTwoNumbers {
    public static void main(String[] arg) {
        Scanner console = new Scanner(System.in);
        double num1 = Double.parseDouble(console.nextLine());
        double num2 = Double.parseDouble(console.nextLine());
        double result = num1 + num2;
        System.out.println(result);

    }
}


