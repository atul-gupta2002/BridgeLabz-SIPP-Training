package Arrays;

import java.util.*;
public class CheckPositiveorNegative {
	public static void main(String[] args) {
		int[] arr = new int[5];
		Scanner sc = new Scanner (System.in);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("Enter the numbers for the array : ");
			arr[i]=sc.nextInt();
			
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i] <0) {
				System.out.println("The number is negative.");
			}else if(arr[i]==0){
				System.out.println("The number is 0.");	
					}
			else {
				if(arr[i]>0) {
					if(arr[i]%2==0) {
						System.out.println("The number is even.");
					}else {
						System.out.println("The number is odd.");
					}
				}
			}
		}
		if(arr[0]==arr[arr.length-1]) {
			System.out.println("The first and last element are equal.");
		}else if(arr[0] < arr[arr.length-1]){
			System.out.println("The first is less and last element is greater.");	
		}else {
			if(arr[0] > arr[arr.length-1]){
				System.out.println("The first is greater and last element is less.");	
		}
		}
	}

}
