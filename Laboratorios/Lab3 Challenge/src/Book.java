public class Book {
    private String title;
    private Double price;
    private Author author;

    public Book(String title, Double price, Author author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', price=" + price + ", author='" + author + "'}";
    }
}