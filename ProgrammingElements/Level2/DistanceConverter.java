package level02;

import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        
        double distanceInFeet, distanceInYards, distanceInMiles;
 
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the distance in feet: ");
        
        distanceInFeet = input.nextDouble();

    
        distanceInYards = distanceInFeet / 3;
        distanceInMiles = distanceInYards / 1760;

        System.out.printf("The distance in yards is %.2f while the distance in miles is %.4f%n", distanceInYards, distanceInMiles);

    }
}
