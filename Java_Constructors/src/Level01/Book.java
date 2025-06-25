package Level01;

public class Book {
    // Instance variables
    String title;
    String author;
    double price;

    // Default constructor
    public Book() {
        title = "Unknown Title";
        author = "Unknown Author";
        price = 0.0;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
    }

    // Main method to test
    public static void main(String[] args) {
        // Using default constructor
        Book book1 = new Book();
        book1.displayInfo();

        System.out.println();

        // Using parameterized constructor
        Book book2 = new Book("Atomic Habits", "James Clear", 499.0);
        book2.displayInfo();
    }
}

