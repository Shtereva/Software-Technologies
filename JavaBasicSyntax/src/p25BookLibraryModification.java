import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class p25BookLibraryModification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Library> result = new ArrayList<>();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");

            Book books= new Book(line[0], line[1], line[2], LocalDate.parse(line[3], df), line[4], Double.parseDouble(line[5]));
            Library library = new Library();
            library.setBooks(new ArrayList<Book>());
            library.setName(books.getAuthor());
            library.getBooks().add(books);

            if (result.stream().noneMatch(x -> x.getName().equals(books.getAuthor()))) {
                result.add(library);
            }else {
                for (int j = 0; j < result.size(); j++) {
                    if (result.get(j).getName().equals(books.getAuthor())) {
                        result.get(j).getBooks().add(books);
                        break;
                    }

                }
            }
        }

        LocalDate date = LocalDate.parse(scanner.nextLine(), df);

        result.stream()
                .flatMap(x -> x.getBooks().stream())
                .filter(x -> x.getReleaseDate().isAfter(date))
                .sorted((a,b) -> {
                    int compared = a.getReleaseDate().compareTo(b.getReleaseDate());
                    if (compared == 0) {
                        compared = a.getTitle().compareTo(b.getTitle());
                    }
                    return compared;
                })
                .forEach(x -> System.out.printf("%s -> %s%n", x.getTitle(), x.getReleaseDate().format(df)));

    }

}
