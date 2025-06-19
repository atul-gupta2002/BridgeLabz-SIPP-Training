package Arrays;

import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1));
            physics[i] = inputMark(sc, "Physics");
            chemistry[i] = inputMark(sc, "Chemistry");
            maths[i] = inputMark(sc, "Maths");

            int total = physics[i] + chemistry[i] + maths[i];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 90) grade[i] = 'A';
            else if (percentage[i] >= 75) grade[i] = 'B';
            else if (percentage[i] >= 60) grade[i] = 'C';
            else if (percentage[i] >= 40) grade[i] = 'D';
            else grade[i] = 'F';
        }

        System.out.println("\nResults:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d - Phy: %d, Chem: %d, Math: %d, %%: %.2f, Grade: %c\n",
                (i + 1), physics[i], chemistry[i], maths[i], percentage[i], grade[i]);
        }

      
    }

    public static int inputMark(Scanner sc, String subject) {
        int mark;
        while (true) {
            System.out.print("Enter marks for " + subject + ": ");
            mark = sc.nextInt();
            if (mark >= 0) return mark;
            System.out.println("Invalid! Marks must be positive.");
        }
    }
}
