package Arrays;

import java.util.Scanner;

public class VotingEligibilityChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] studentAges = new int[10]; 

      
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            studentAges[i] = scanner.nextInt();
        }

       
        for (int i = 0; i < studentAges.length; i++) {
            int age = studentAges[i];

            if (age < 0) {
                System.out.println("Student " + (i + 1) + " has an invalid age: " + age);
            } else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }

      
    }
}
