package io.github.ndimovt.exc8;

import java.util.Scanner;

public class MatrixAddition {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String[] arr = inn.nextLine().split(" ");
        int[][] matrix = new int[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])];
        int[][] secondMatrix = new int[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])];
        int[][] sum = new int[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])];

        for (int i = 0; i < Integer.parseInt(arr[0]); i++) {
            String[] elements = inn.nextLine().split(" ");
            for (int j = 0; j < Integer.parseInt(arr[1]); j++) {
                matrix[i][j] = Integer.parseInt(elements[j]);
            }
        }

        for (int i = 0; i < Integer.parseInt(arr[0]); i++) {
            String[] elements = inn.nextLine().split(" ");
            for (int j = 0; j < Integer.parseInt(arr[1]); j++) {
                secondMatrix[i][j] = Integer.parseInt(elements[j]);
            }
        }

        for (int i = 0; i < Integer.parseInt(arr[0]) ; i++) {
            for (int j = 0; j < Integer.parseInt(arr[1]); j++) {
                sum[i][j] = matrix[i][j] + secondMatrix[i][j];
            }
        }
        for (int i = 0; i < Integer.parseInt(arr[0]); i++) {
            for (int j = 0; j < Integer.parseInt(arr[1]); j++) {
                System.out.print(sum[i][j]+" ");
            }
            System.out.println();
        }
    }
}
