package Arrays;

import java.util.Scanner;

public class BonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salary = new double[10];
        double[] service = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0, totalOld = 0, totalNew = 0;

        for (int i = 0; i < 10; ) {
            System.out.println("Enter salary and years of service for Employee " + (i + 1));
            double s = sc.nextDouble();
            double y = sc.nextDouble();

            if (s <= 0 || y < 0) {
                System.out.println("Invalid input! Please enter again.");
                continue; 
            }

            salary[i] = s;
            service[i] = y;

            if (y > 5)
                bonus[i] = 0.05 * s;
            else
                bonus[i] = 0.02 * s;

            newSalary[i] = s + bonus[i];

            totalBonus += bonus[i];
            totalOld += s;
            totalNew += newSalary[i];
            i++;
        }

        System.out.println("\n--- Bonus Report ---");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Employee %d: Old Salary = %.2f, Bonus = %.2f, New Salary = %.2f\n",
                    i + 1, salary[i], bonus[i], newSalary[i]);
        }

        System.out.printf("\nTotal Bonus Payout = %.2f\nTotal Old Salary = %.2f\nTotal New Salary = %.2f\n",
                totalBonus, totalOld, totalNew);
    }
}

