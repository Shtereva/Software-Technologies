import java.util.*;

public class p12BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");


        ArrayList<Integer> numbers = new ArrayList<>();

        for (String num : input) {
            numbers.add(Integer.parseInt(num));
        }

        int[] specialNumber = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bombNumber = specialNumber[0];
        int power = specialNumber[1];
        int sum = 0;

        FindingBombNumberIndex(numbers, bombNumber, power);
        sum = SumNumbers(numbers, sum);

        System.out.println(sum);
    }

    private static int SumNumbers(ArrayList<Integer> numbers, int sum) {
        for (int i = 0; i < numbers.size(); i++) {
             sum += numbers.get(i);
        }

        return sum;
    }

    private static void FindingBombNumberIndex(ArrayList<Integer> numbers, int bombNumber, int power) {
        for (int i = 0; i < numbers.size(); i++)
        {
            boolean hasMatch = numbers.contains(bombNumber);

            if (!hasMatch)
            {
                return;
            }
            if (numbers.get(i).equals(bombNumber))
            {
                BombingNumbers(numbers, power, i);
                i = -1;
            }
        }
    }

    private static void BombingNumbers(ArrayList<Integer> numbers, int power, int i) {
        if (i - power >= 0 && i + power <= numbers.size() - 1)
        {
            numbers.subList(i - power, (power + i) + 1).clear();

        }

        else if (i - power >= 0 && i + power > numbers.size() - 1)
        {
            numbers.subList(i - power, numbers.size()).clear();
        }

        else if (i - power < 0 && i + power <= numbers.size() - 1)
        {
            numbers.subList(0, i + 1 + power).clear();
        }

        else
        {
            numbers.subList(0, numbers.size()).clear();
        }
    }

}
