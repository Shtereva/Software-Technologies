import java.io.Console;
import java.util.*;

public class p21AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] phrases = new String[]{

                "Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.",
                        "Exceptional product.", "I can’t live without this product."
        };

        String[] events = new String[]{

                "Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                        "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"
        };

        String[] authors = new String[]
        {
                "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"
        };

        String[] towns = new String[]
        {
                "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"
        };

        Random random = new Random();

        for (int i = 0; i < n; i++)
        {
            int phraseIndex = random.nextInt(phrases.length);
            int eventIndex = random.nextInt(events.length);
            int authorIndex = random.nextInt(authors.length);
            int townIndex = random.nextInt(towns.length);

            System.out.println(phrases[phraseIndex] + " " + events[eventIndex] + " " + authors[authorIndex] +
            " " + towns[townIndex]);
        }
    }

}
