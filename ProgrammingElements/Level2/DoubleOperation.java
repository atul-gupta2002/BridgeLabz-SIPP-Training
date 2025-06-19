package level02;

import java.util.*;

public class DoubleOperation {
    public static void main(String[] args) {
        
        double a, b, c;
        double result1, result2, result3, result4;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter value for a: ");
        a = input.nextDouble();

        System.out.print("Enter value for b: ");
        b = input.nextDouble();

        System.out.print("Enter value for c: ");
        c = input.nextDouble();

        result1 = a + b * c;      
        result2 = a * b + c;       
        result3 = c + a / b;       
        result4 = a % b + c;       
  
        System.out.println("The results of Double Operations are:");
        System.out.printf("a + b * c = %.2f%n", result1);
        System.out.printf("a * b + c = %.2f%n", result2);
        System.out.printf("c + a / b = %.2f%n", result3);
        System.out.printf("a %% b + c = %.2f%n", result4); 

    }
}

