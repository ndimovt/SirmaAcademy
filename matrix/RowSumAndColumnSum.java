package io.github.ndimovt.matrix;

import java.util.Scanner;

public class RowSumAndColumnSum {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int rows = inn.nextInt();
        int columns = inn.nextInt();
        inn.nextLine();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows ; i++) {
            String[] elements = inn.nextLine().split(" ");
            for (int j = 0; j < elements.length ; j++) {
                matrix[i][j] = Integer.parseInt(elements[j]);
            }
        }

        System.out.print("Row sum: ");
        for (int i = 0; i < rows ; i++) {
            int sum = 0;
            for (int j = 0; j < columns ; j++) {
                sum += matrix[i][j];
            }
            System.out.print(sum+", ");
        }
        System.out.println();
        System.out.print("Column sum: ");
        for (int i = 0; i < columns ; i++) {
            int sum = 0;
            for (int j = 0; j < rows ; j++) {
                sum += matrix[j][i];
            }
            System.out.print(sum+", ");
        }
        System.out.println();
    }
}
