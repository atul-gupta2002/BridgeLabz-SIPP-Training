package Arrays;

import java.util.*;

public class ShowMultiplevalues {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		int sum=0;
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("Enter a number : ");
			arr[i]=sc.nextInt();
			if(arr[i]==0 || arr[i]<0) {
				break;
			}
		}
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
			
			
		}
		System.out.println("The array is : "+ Arrays.toString(arr));
		System.out.println("The sum of the array elements is" + " "+sum);
		
	}

}
