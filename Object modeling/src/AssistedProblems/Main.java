package AssistedProblems;

import java.util.ArrayList;

// Book class - Can exist independently
class Book {
    public String title;
    public String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Display book details
    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

// Library class - Aggregates Book objects
class Library {
    public String name;
    public ArrayList<Book> books;

    // Constructor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display library details
    public void displayLibrary() {
        System.out.println("Library: " + name);
        System.out.println("Books in this library:");
        for (Book book : books) {
            book.displayBook();
        }
        System.out.println();
    }
}

// Main class to test aggregation
public class Main {
    public static void main(String[] args) {
        // Create independent Book objects
        Book book1 = new Book("The Alchemist", "Paulo Coelho");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("Clean Code", "Robert C. Martin");

        // Create Library objects
        Library cityLibrary = new Library("City Library");
        Library universityLibrary = new Library("University Library");

        // Add books to libraries (Aggregation)
        cityLibrary.addBook(book1);
        cityLibrary.addBook(book2);

        universityLibrary.addBook(book2); // same book in another library
        universityLibrary.addBook(book3);

        // Display libraries and their books
        cityLibrary.displayLibrary();
        universityLibrary.displayLibrary();
    }
}
