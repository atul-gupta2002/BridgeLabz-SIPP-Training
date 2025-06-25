package Level01;

public class bookBorrow {
    String title;
    String author;
    double price;
    boolean isAvailable;

    // Parameterized constructor
    public bookBorrow(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Method to borrow a book
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully: " + title);
        } else {
            System.out.println("Sorry, the book \"" + title + "\" is currently not available.");
        }
    }

    // Method to display book info
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    // Main method to test
    public static void main(String[] args) {
        bookBorrow book1 = new bookBorrow("Clean Code", "Robert C. Martin", 699.0, true);

        book1.displayInfo();
        System.out.println();

        book1.borrowBook(); // Should succeed
        book1.borrowBook(); // Should fail
    }
}

