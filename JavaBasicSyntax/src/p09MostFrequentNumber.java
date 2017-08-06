import java.util.Scanner;

public class p09MostFrequentNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        String output = "";
        int counter = 1;
        int maxCounter = 0;

        int decreased = 2;
        for (int i = array.length - 1; i >= 0; i--)
        {
            for (int j = array.length - decreased; j >= 0; j--)
            {
                if (array[i].equals(array[j]))
                {
                    counter++;
                }

            }

            if (counter >= maxCounter)
            {
                output = array[i];
                maxCounter = counter;
            }

            decreased++;
            counter = 1;
        }

        System.out.println(output);
    }

}
