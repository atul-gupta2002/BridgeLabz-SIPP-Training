package level01;

import java.util.Scanner;

public class StudentFeeCalculator {
    public static void main(String[] args) {
       
        double fee, discountPercent, discount, finalFee;
        
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter the total student fee (INR): ");
        fee = sc.nextDouble();

        System.out.print("Enter the university discount percentage: ");
        discountPercent = sc.nextDouble();

        discount = (fee * discountPercent) / 100;
        finalFee = fee - discount;

        System.out.printf("The discount amount is INR %.2f and final discounted fee is INR %.2f%n", discount, finalFee);
    }
}

