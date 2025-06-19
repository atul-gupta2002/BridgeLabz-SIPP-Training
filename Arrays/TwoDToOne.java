package Arrays;

import java.util.Scanner;

public class TwoDToOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        int[] oneD = new int[rows * cols];
        int index = 0;

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
                oneD[index++] = matrix[i][j];
            }
        }

        System.out.print("1D Array: ");
        for (int i = 0; i < oneD.length; i++) {
            System.out.print(oneD[i] + " ");
        }

    }
}

