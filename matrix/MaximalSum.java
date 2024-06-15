package io.github.ndimovt.matrix;

import java.util.Scanner;

public class MaximalSum {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] biggest = new int[3][3];
        int max = 0, current = 0, index00 = 0, index01 = 0, index02, index10 = 0, index11 = 0, index12 = 0, index20 = 0, index21 = 0, index22 = 0;
        String[] size = inn.nextLine().split(" ");
        int row = Integer.parseInt(size[0]);
        int column = Integer.parseInt(size[1]);

        int[][] matrix = new int[row][column];
        for (int i = 0; i < row ; i++) {
            String[] nums = inn.nextLine().split(" ");
            for (int j = 0; j < column ; j++) {
                matrix[i][j] = Integer.parseInt(nums[j]);
            }
        }
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < column - 2; j++) {
                current = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2]+ matrix[i+1][j] + matrix[i+1][j+1] +
                        matrix[i+1][j+2] + matrix[i+2][j] + matrix[i+2][j+1] + matrix[i+2][j+2];
                if(current > max){
                    max = current;
                    biggest[0][0] = matrix[i][j];
                    biggest[0][1] = matrix[i][j+1];
                    biggest[0][2] = matrix[i][j+2];
                    biggest[1][0] = matrix[i+1][j];
                    biggest[1][1] = matrix[i+1][j+1];
                    biggest[1][2] = matrix[i+1][j+2];
                    biggest[2][0] = matrix[i+2][j];
                    biggest[2][1] = matrix[i+2][j+1];
                    biggest[2][2] = matrix[i+2][j+2];
                }
            }
        }
        System.out.println("Sum = " + max);
        printMatrix(biggest);
    }
    private static void printMatrix(int[][] arr){
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3 ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
