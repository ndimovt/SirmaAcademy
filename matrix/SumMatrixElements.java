package io.github.ndimovt.exc8;

import java.util.Scanner;

public class SumMatrixElements {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String[] size = inn.nextLine().split(" ");
        int[][] matrix = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
        int sum = 0, row = 0, column = 0;

        for (int i = 0; i < Integer.parseInt(size[0]) ; i++) {
            String[] elements = inn.nextLine().split(" ");
            for (int j = 0; j < Integer.parseInt(size[1]) ; j++) {
                matrix[i][j] = Integer.parseInt(elements[j]);
            }
        }

        for (int i = 0; i < Integer.parseInt(size[0]) ; i++) {
            for (int j = 0; j < Integer.parseInt(size[1]); j++) {
                sum += matrix[i][j];
            }
        }

        row = Integer.parseInt(size[0]);
        column = Integer.parseInt(size[1]);

        System.out.printf("\n %d \n %d \n %d \n", row, column, sum);

    }
}
