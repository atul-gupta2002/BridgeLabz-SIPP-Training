package level02;
import java.util.*;

public class BasicCalculator {
	 public static void main(String[] args) {
	        
	        double number1, number2;
	        double sum, difference, product, quotient;
	        
	        Scanner input = new Scanner(System.in);

	        System.out.print("Enter the first number: ");
	        number1 = input.nextDouble();

	        System.out.print("Enter the second number: ");
	        number2 = input.nextDouble();

	        sum = number1 + number2;
	        difference = number1 - number2;
	        product = number1 * number2;
	        quotient = number2 != 0 ? number1 / number2 : Double.NaN; 
	        
	        System.out.printf("The addition, subtraction, multiplication, and division value of 2 numbers %.2f and %.2f is %.2f, %.2f, %.2f, and %.2f%n",
	                          number1, number2, sum, difference, product, quotient);

	    }

}
