package Level01;

public class Circle {
    double radius;

    // Default constructor (calls parameterized constructor with default value)
    public Circle() {
        this(1.0);  // default radius is 1.0
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Method to display radius and area
    public void displayInfo() {
        System.out.println("Radius: " + String.format("%.3f", radius));
        System.out.println("Area: " + String.format("%.3f", getArea()));
    }

    // Main method to test
    public static void main(String[] args) {
        Circle c1 = new Circle();           // uses default constructor
        Circle c2 = new Circle(5.5);        // uses parameterized constructor

        c1.displayInfo();
        System.out.println();
        c2.displayInfo();
    }
}

