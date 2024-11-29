public class Main {
    public static void main(String[] args) {
        Author author = new Author("George Orwell");

        // Agregar un libro completo
        Book book1 = new Book("1984", 9.99, author);
        author.addBooks(book1);

        // Agregar un libro con solo título y precio
        author.addBooks("Animal Farm", 7.99);

        // Imprimir todos los libros del autor
        System.out.println("Books by " + author.name + ":");
        author.getBooks();
    }
}
