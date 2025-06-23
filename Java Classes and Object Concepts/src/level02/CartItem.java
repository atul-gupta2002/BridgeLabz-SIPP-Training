package level02;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    void addItem(int qty) {
        quantity += qty;
        System.out.println(qty + " item(s) added.");
    }

    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println(qty + " item(s) removed.");
        } else {
            System.out.println("Cannot remove more than present.");
        }
    }

    double getTotalCost() {
        return price * quantity;
    }

    void displayCart() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per item: ₹" + price);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Total Cost: ₹%.2f\n", getTotalCost());
    }

    public static void main(String[] args) {
        CartItem cart = new CartItem("Headphones", 999.99, 1);
        cart.addItem(2);
        cart.removeItem(1);
        cart.displayCart();
    }
}
