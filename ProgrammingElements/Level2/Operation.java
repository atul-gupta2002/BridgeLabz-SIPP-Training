package level02;
import java.util.*;

public class Operation {
	 public static void main(String[] args) {
		 
	        int a, b, c;
	        int result1, result2, result3, result4;
	        
	        Scanner input = new Scanner(System.in);
	        
	        System.out.print("Enter value for a: ");
	        a = input.nextInt();

	        System.out.print("Enter value for b: ");
	        b = input.nextInt();

	        System.out.print("Enter value for c: ");
	        c = input.nextInt();

	        result1 = a + b * c;      
	        result2 = a * b + c;      
	        result3 = c + a / b;      
	        result4 = a % b + c;       

	        System.out.println("The results of Int Operations are:");
	        System.out.println("a + b * c = " + result1);
	        System.out.println("a * b + c = " + result2);
	        System.out.println("c + a / b = " + result3);
	        System.out.println("a % b + c = " + result4);

	    }

}
