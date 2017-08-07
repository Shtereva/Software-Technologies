import java.time.LocalDate;

public class Book {
    private String Title;
    private String Author;
    private String Publisher;
    private LocalDate ReleaseDate;
    private String ISBN;
    private double Price;

    public Book(String title, String author, String publisher, LocalDate releaseDate, String ISBN, double price) {
        Title = title;
        Author = author;
        Publisher = publisher;
        ReleaseDate = releaseDate;
        this.ISBN = ISBN;
        Price = price;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public LocalDate getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
