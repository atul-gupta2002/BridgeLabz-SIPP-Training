package level02;
import java.util.*;

public class TotalPriceCalculator {
	public static void main(String[] args) {
        
        double unitPrice, totalPrice;
        int quantity;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the unit price (INR): ");
        unitPrice = input.nextDouble();

        System.out.print("Enter the quantity: ");
        quantity = input.nextInt();

   
        totalPrice = unitPrice * quantity;

        System.out.printf("The total purchase price is INR %.2f if the quantity is %d and unit price is INR %.2f%n",
                          totalPrice, quantity, unitPrice);

    }

}
