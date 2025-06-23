package level01;

class Circle {
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    double calculateArea() {
        return Math.PI * radius * radius;
    }
    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
    void displayDetails() {
        System.out.printf("Radius: %.3f\n", radius);
        System.out.printf("Area: %.3f\n", calculateArea());
        System.out.printf("Circumference: %.3f\n", calculateCircumference());
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.displayDetails();
    }
}
