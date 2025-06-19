package level02;
import java.util.*;

public class TriangleAreaConverter {
	 public static void main(String[] args) {
	        
	        double base, height;
	        double areaSqCm, areaSqIn;
	        Scanner input = new Scanner(System.in);

	        System.out.print("Enter base of the triangle (in cm): ");
	        base = input.nextDouble();

	        System.out.print("Enter height of the triangle (in cm): ");
	        height = input.nextDouble();
	        
	        areaSqCm = 0.5 * base * height;

	        areaSqIn = areaSqCm / (2.54 * 2.54); 
	        
	        System.out.printf("The Area of the triangle in sq in is %.2f and sq cm is %.2f%n", areaSqIn, areaSqCm);

	 }

}
