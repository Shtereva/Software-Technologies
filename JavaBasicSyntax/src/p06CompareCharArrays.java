import java.util.Scanner;

public class p06CompareCharArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  line1 = scanner.nextLine().replace(" ", "").toString();
        String line2 = scanner.nextLine().replace(" ", "").toString();

        System.out.println(line1.compareTo(line2) <= 0 ? line1 + "\n" + line2 : line2 + "\n" + line1);

    }

}
