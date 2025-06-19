package level02;
import java.util.*;

public class SquareSideFinder {
	  public static void main(String[] args) {
	       
	        double perimeter, side;
	        Scanner input = new Scanner(System.in);

	        System.out.print("Enter the perimeter of the square: ");
	        perimeter = input.nextDouble();

	        side = perimeter / 4;

	        System.out.printf("The length of the side is %.2f whose perimeter is %.2f%n", side, perimeter);

	    
	}

}
