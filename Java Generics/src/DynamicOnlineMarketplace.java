abstract class Category {}
class BookCategory extends Category {}
class ClothingCategory extends Category {}
class GadgetCategory extends Category {}

class Product<T extends Category> {
    private String name;
    private double price;
    public Product(String name, double price) {
        this.name = name; this.price = price;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getName() { return name; }
}

public class DynamicOnlineMarketplace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(newPrice);
        System.out.println("Discounted price of " + product.getName() + ": " + newPrice);
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Guide", 500);
        applyDiscount(book, 10);
    }
}

