package multiLevelInheritance;

class Order {
    String orderId;
    String orderDate;

    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order placed";
    }

    void displayInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}
class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order shipped";
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order delivered";
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

public class OrderManagementSystem {
    public static void main(String[] args) {
        System.out.println("----- Base Order -----");
        Order order = new Order("O123", "2025-07-01");
        order.displayInfo();

        System.out.println("\n----- Shipped Order -----");
        ShippedOrder shipped = new ShippedOrder("O124", "2025-07-01", "TRK56789");
        shipped.displayInfo();

        System.out.println("\n----- Delivered Order -----");
        DeliveredOrder delivered = new DeliveredOrder("O125", "2025-07-01", "TRK12345", "2025-07-02");
        delivered.displayInfo();
    }
}

