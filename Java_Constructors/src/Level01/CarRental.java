package Level01;

public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double ratePerDay;

    // Default constructor
    public CarRental() {
        customerName = "Unknown";
        carModel = "Standard";
        rentalDays = 1;
        ratePerDay = 1000.0; // default rate per day
    }

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays, double ratePerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.ratePerDay = ratePerDay;
    }

    // Method to calculate total cost
    public double calculateTotalCost() {
        return rentalDays * ratePerDay;
    }

    // Display rental details
    public void displayDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Rate per Day: ₹" + ratePerDay);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
    }

    // Main method to test
    public static void main(String[] args) {
        // Using default constructor
        CarRental rental1 = new CarRental();
        rental1.displayDetails();

        System.out.println();

        // Using parameterized constructor
        CarRental rental2 = new CarRental("Ravi Kumar", "Hyundai i20", 5, 1200.0);
        rental2.displayDetails();
    }
}

