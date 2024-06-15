package io.github.ndimovt.exc8;

import java.util.Scanner;

public class MatrixBoundarySum {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String[] size = inn.nextLine().split(" ");
        int row = Integer.parseInt(size[0]);
        int column = Integer.parseInt(size[1]);
        int[][] matrix = new int[row][column];
        int sum = 0;

        for (int i = 0; i < row ; i++) {
            String[] nums = inn.nextLine().split(" ");
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Integer.parseInt(nums[j]);
            }
        }
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < column ; j++) {
                if(i == 0 || i == row - 1 || j == 0 || j == column - 1){
                    sum += matrix[i][j];
                }
            }
        }

        System.out.println(sum);
    }
}
