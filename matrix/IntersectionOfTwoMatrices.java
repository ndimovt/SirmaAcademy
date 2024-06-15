package io.github.ndimovt.exc8;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int rows = inn.nextInt();
        int columns = inn.nextInt();
        inn.nextLine();
        String[][] matrix = new String[rows][columns];
        String[][] secondMatrix = new String[rows][columns];
        String[][] result = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] elements =inn.nextLine().split(" ");
            for (int j = 0; j < columns; j++) {
                if (!elements[j].equals("*")) {
                    matrix[i][j] = elements[j];
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            String[] elements =inn.nextLine().split(" ");
            for (int j = 0; j < columns; j++) {
                if (!elements[j].equals("*")) {
                    secondMatrix[i][j] = elements[j];
                }
            }
        }

        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < columns; j++) {
                if(matrix[i][j].equals(secondMatrix[i][j])){
                    result[i][j] = matrix[i][j];
                }else {
                    result[i][j] = "*";
                }
            }
        }

        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < columns ; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
