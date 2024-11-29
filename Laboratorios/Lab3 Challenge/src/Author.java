import java.util.ArrayList;

public class Author {

    public String name;
    private ArrayList<Book> books;

    // Constructor para inicializar el nombre del autor y la lista de libros
    public Author(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Método para agregar un libro completo
    public void addBooks(Book book) {
        this.books.add(book);
    }

    // Método para agregar un libro solo con título y precio
    public void addBooks(String title, Double price) {
        Book book = new Book(title, price, null); // Autor nulo porque no se especifica
        this.books.add(book);
    }

    // Método para imprimir todos los libros del autor
    public void getBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
