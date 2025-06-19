package Arrays;

import java.util.Scanner;

public class ReverseDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;
        int count = 0;

        while (temp > 0) {
            temp /= 10;
            count++;
        }

        int[] digits = new int[count];
        temp = number;

        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        System.out.print("Reversed digits: ");
        for (int i = 0; i < count; i++) {
            System.out.print(digits[i]);
        }

        
    }
}

