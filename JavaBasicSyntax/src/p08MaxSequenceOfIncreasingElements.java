import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p08MaxSequenceOfIncreasingElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");

        int start = array.length - 1;
        int len = 1;
        int bestStart = 0;
        int bestLen = 0;

        for (int i = array.length - 2; i >= 0; i--) {
            if (Integer.parseInt(array[i]) < Integer.parseInt(array[i + 1])) {
                len++;
                if (len >= bestLen) {
                    bestStart = start;
                    bestLen = len;
                }
            } else {
                start = i;
                len = 1;
            }
        }

            String[] finalArray = new String[bestLen];

            int index = 0;
            for (int i = bestStart; i > bestStart - bestLen; i--)
            {
                finalArray[index] = (array[i]);
                index++;
            }

        if (len == 1 && bestLen == 0)
        {
            System.out.println(Collections.min(Arrays.asList(array)));
        }
        else
        {
            Collections.reverse(Arrays.asList(finalArray));
            System.out.println(String.join(" ", finalArray));
        }
    }

}
