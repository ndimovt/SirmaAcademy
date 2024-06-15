package io.github.ndimovt.matrix;

import java.util.Scanner;

public class MatrixDiagonalSum {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int firstDiagonalSum = 0, secondDiagonalSum = 0;
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
        for (int i = 0; i < rows; i++) {
            firstDiagonalSum += matrix[i][i];
        }
        for (int i = rows-1; i >= 0; i--) {
            secondDiagonalSum += matrix[i][rows - 1 - i];
        }
        System.out.println(firstDiagonalSum + secondDiagonalSum);
    }

}
