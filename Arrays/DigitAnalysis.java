package Arrays;

import java.util.Scanner;

public class DigitAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int maxDigits = 10;
        int[] digits = new int[maxDigits];
        int index = 0;

        while (number != 0) {
            int digit = number % 10;
            number /= 10;

            if (index == maxDigits) {
                maxDigits *= 2;
                int[] temp = new int[maxDigits];
                System.arraycopy(digits, 0, temp, 0, index);
                digits = temp;
            }

            digits[index++] = digit;
        }

        if (index == 0) {
            System.out.println("No digits found.");
            return;
        }

        int largest = -1, secondLargest = -1;
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest digit: " + largest);
        if (secondLargest == -1)
            System.out.println("No second largest digit found.");
        else
            System.out.println("Second largest digit: " + secondLargest);
    }
}

