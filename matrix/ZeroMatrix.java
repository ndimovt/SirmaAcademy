package io.github.ndimovt.matrix;

import java.util.Arrays;
import java.util.Scanner;

public class ZeroMatrix {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String[] size = inn.nextLine().split(" ");
        int row = Integer.parseInt(size[0]);
        int column = Integer.parseInt(size[1]);
        int[][] matrix = new int[row][column];
        boolean[] zeroRow = new boolean[row];
        boolean[] zeroColumn = new boolean[column];
        for (int i = 0; i < row ; i++) {
            String[] nums = inn.nextLine().split(" ");
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Integer.parseInt(nums[j]);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column ; j++) {
                if(matrix[i][j] == 0){
                    zeroRow[i] = true;
                    zeroColumn[j] = true;
                }
            }
        }

        for (int i = 0; i < row ; i++) {
            if(zeroRow[i]){
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int j = 0; j < column ; j++) {
            if(zeroColumn[j]){
                for (int i = 0; i < row ; i++) {
                    matrix[i][j] = 0;
                }
            }

        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
