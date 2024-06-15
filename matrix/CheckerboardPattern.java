package io.github.ndimovt.matrix;

import java.util.Scanner;

public class CheckerboardPattern {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int size = inn.nextInt();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i % 2 == 0) {
                    matrix[i][j] = 1;
                    if(j % 2 == 0){
                        matrix[i][j] = 0;
                    }
                }

                if (i % 2 != 0) {
                    matrix[i][j] = 1;
                    if(j % 2 != 0){
                        matrix[i][j] = 0;
                    }
                }

            }
        }
        print(matrix, size);
    }
    private static void print(int[][] arr, int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
