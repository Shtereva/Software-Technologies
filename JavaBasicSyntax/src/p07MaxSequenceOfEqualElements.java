
import java.util.Scanner;

public class p07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");

        int start = array.length - 1;
        int len = 1;
        int bestStart = 0;
        int bestLen = 0;

        for (int i = array.length - 2; i >= 0; i--)
        {
            if (array[i].equals(array[i + 1]))
            {
                len++;
                if (len >= bestLen)
                {
                    bestStart = start;
                    bestLen = len;
                }
            }

            else
            {
                start = i;
                len = 1;
            }
        }

        for (int i = bestStart; i > bestStart - bestLen; i--)
        {
            System.out.print(array[i]);
            System.out.print(" ");
        }

        System.out.println();
    }

}
