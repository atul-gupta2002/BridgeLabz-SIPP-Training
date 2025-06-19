package level01;
import java.util.*;

public class HeightConverter {
	 public static void main(String[] args) {
	       
	        double heightCm, totalInches, heightFeet, remainingInches;
	        
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter your height in centimeters: ");
	        heightCm = sc.nextDouble();

	        totalInches = heightCm / 2.54;

	        heightFeet = (int)(totalInches / 12);
	        remainingInches = totalInches % 12;

	        System.out.printf("Your Height in cm is %.2f while in feet is %.0f and inches is %.2f%n", heightCm, heightFeet, remainingInches);
	    }

}
