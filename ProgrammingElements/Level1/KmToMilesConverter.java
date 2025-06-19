package level01;
import java.util.Scanner;

public class KmToMilesConverter {
	public static void main(String[] args) {
        
        double km;

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter distance in kilometers: ");
        km = sc.nextInt(); 
        double miles = km / 1.6;

        System.out.printf("The total miles is %.4f mile for the given %.2f km%n", miles, km);
        
    }

}
