package io.github.ndimovt.matrix;

import java.util.Scanner;

public class FillTheMatrix {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String[] pattern = inn.nextLine().split(" ");
        int row = Integer.parseInt(pattern[0]);
        String letter = pattern[1];
        int[][] matrix = new int[row][row];
        int start = 1;
        switch (letter){
            case "A", "a":
                for (int i = 0; i < row ; i++) {
                    for (int j = 0; j < row ; j++) {
                        matrix[j][i] = start++;
                    }
                }
                printMatrix(matrix, row);
                break;
            case "B", "b":
                for (int i = 0; i < row; i++) {
                    if(i % 2 == 0){
                        for (int j = 0; j < row ; j++) {
                            matrix[j][i] = start++;
                        }
                    }else{
                        for (int j = row - 1; j >= 0; j--) {
                            matrix[j][i] = start++;
                        }
                    }
                }
                printMatrix(matrix, row);
                break;
            default:
                break;
        }
    }
    private static void printMatrix(int[][] array, int row){
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < row ; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
