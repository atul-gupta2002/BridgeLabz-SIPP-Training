package SelfProblems;

import java.util.*;

// Product class – shared and can exist independently
class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void showProduct() {
        System.out.println("• " + name + " - ₹" + price);
    }
}

// Order class – Aggregates Product objects
class Order {
    private static int orderCounter = 100;
    private int orderId;
    private List<Product> products;
    private Date date;

    public Order() {
        this.orderId = orderCounter++;
        this.products = new ArrayList<>();
        this.date = new Date();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrder() {
        System.out.println("Order ID: #" + orderId + " | Date: " + date);
        System.out.println("Products:");
        double total = 0;
        for (Product p : products) {
            p.showProduct();
            total += p.getPrice();
        }
        System.out.println("Total: ₹" + total + "\n");
    }
}

// Customer class – Associated with Orders
class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    // Communication through placing an order
    public void placeOrder(Product... products) {
        Order order = new Order();
        for (Product product : products) {
            order.addProduct(product);
        }
        orders.add(order);
        System.out.println(name + " placed an order with " + products.length + " product(s).");
    }

    public void viewOrders() {
        System.out.println("\nCustomer: " + name + " - Order History:");
        for (Order o : orders) {
            o.showOrder();
        }
    }
}

// Main class to test the platform
public class Main6 {
    public static void main(String[] args) {
        // Create products (independent of orders)
        Product laptop = new Product(1, "Laptop", 75000);
        Product phone = new Product(2, "Smartphone", 25000);
        Product mouse = new Product(3, "Wireless Mouse", 1500);

        // Create customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Customers place orders (association + aggregation)
        alice.placeOrder(laptop, mouse);
        bob.placeOrder(phone);
        alice.placeOrder(phone, mouse);

        // View order histories
        alice.viewOrders();
        bob.viewOrders();
    }
}

