import java.util.Scanner;
import java.util.TreeMap;

public class p19PhonebookUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeMap<String, String> phoneBook = new TreeMap<>();

        while (!input.equals("END")){
            String[] line = input.split(" ");

            if (line[0].equals("A")) {
                phoneBook.put(line[1], line[2]);
            }else if (line[0].equals("S")) {
                System.out.println(phoneBook.containsKey(line[1]) ? line[1] + " -> " + phoneBook.get(line[1]) :
                        "Contact " + line[1] + " does not exist.");
            } else {
                phoneBook.forEach((k,v) -> System.out.println(k + " -> " + v));
            }

            input = scanner.nextLine();
        }

    }
}
