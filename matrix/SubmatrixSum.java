package io.github.ndimovt.exc8;

import java.util.Scanner;

public class SubmatrixSum {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] biggest = new int[2][2];
        int max = 0, current = 0, index00 = 0, index01 = 0, index10 = 0, index11 = 0;
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
        for (int i = 0; i < row - 1 ; i++) {
            for (int j = 0; j < column - 1; j++) {
                current = matrix[i][j] + matrix[i][j+1] + matrix[i+1][j] + matrix[i+1][j+1];
                if(current > max){
                    max = current;
                    biggest[0][0] = matrix[i][j];
                    biggest[0][1] = matrix[i][j+1];
                    biggest[1][0] = matrix[i+1][j];
                    biggest[1][1] = matrix[i+1][j+1];
                }
            }
        }
        System.out.println(max);
        SubmatrixSum.printMatrix(biggest);
    }
    private static void printMatrix(int[][] arr){
        for (int i = 0; i < 2 ; i++) {
            for (int j = 0; j < 2 ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
