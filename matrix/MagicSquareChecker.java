package io.github.ndimovt.matrix;

import java.util.Scanner;

public class MagicSquareChecker {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int firstDiagonalSum = 0, secondDiagonalSum = 0, rowSum = 0, columnSum = 0;
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

        for (int i = 0; i < rows ; i++) {
            int sum = 0;
            for (int j = 0; j < columns ; j++) {
                sum += matrix[i][j];
            }
            rowSum = sum;
        }

        for (int i = 0; i < columns ; i++) {
            int sum = 0;
            for (int j = 0; j < rows ; j++) {
                sum += matrix[j][i];
            }
            columnSum = sum;
        }
        System.out.println(isMagic(firstDiagonalSum, secondDiagonalSum, rowSum, columnSum));
    }
    private static boolean isMagic(int first, int second, int third, int fourth){
        return first == second && second == third && third == fourth;
    }
}
