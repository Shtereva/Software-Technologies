/*
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p24BookLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Library> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");

            Book books= new Book(line[0], line[1], line[2], line[3], line[4], Double.parseDouble(line[5]));
            Library library = new Library();
            library.setBooks(new ArrayList<Book>());
            library.setName(books.getAuthor());
            library.getBooks().add(books);

            if (result.stream().noneMatch(x -> x.getName().equals(books.getAuthor()))) {
                result.add(library);
            }else {
                for (int j = 0; j < result.size(); j++) {
                    if (result.get(j).getName().equals(books.getAuthor())) {
                        result.get(j).getBooks().get(0).setPrice(result.get(j).getBooks().get(0).getPrice() + books.getPrice());
                        break;
                    }

                }
            }
        }

        result.stream()
                .flatMap(x -> x.getBooks().stream())
                .sorted((a,b) -> {
                int compared = Double.compare(b.getPrice(), a.getPrice());
                    if (compared == 0) {
                        compared = a.getAuthor().compareTo(b.getAuthor());
                    }

                })
                .forEach(x -> System.out.printf("%s -> %.2f%n", x.getAuthor(), x.getPrice()));

    }

}
 */
