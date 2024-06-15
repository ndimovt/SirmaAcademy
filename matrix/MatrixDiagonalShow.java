package io.github.ndimovt.exc8;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixDiagonalShow {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int count = 0;
        int rows = inn.nextInt();
        inn.nextLine();
        int[][] matrix = new int[rows][];
        while(count < rows){
            String[] m = inn.nextLine().split(" ");
            int[] arr = Arrays.stream(m).mapToInt(Integer::parseInt).toArray();
            for (int i = count; i < rows; i++) {
                matrix[count] = arr;
            }
            count++;
        }

        for (int i = 0; i < rows; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        for (int i = rows-1; i >= 0; i--) {
            System.out.print(matrix[i][rows - 1 - i] + " ");
        }
    }
}
