package io.github.ndimovt.exc8;

import java.util.Scanner;

public class MatrixComparator {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {

        int rows1 = inn.nextInt();
        int cols1 = inn.nextInt();
        int[][] matrix1 = readMatrix(inn, rows1, cols1);

        int rows2 = inn.nextInt();
        int cols2 = inn.nextInt();
        int[][] matrix2 = readMatrix(inn, rows2, cols2);

        if (compareMatrices(matrix1, matrix2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    public static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static boolean compareMatrices(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
