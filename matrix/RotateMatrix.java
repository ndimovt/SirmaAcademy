package io.github.ndimovt.matrix;

import java.util.Scanner;

public class RotateMatrix {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String[] size = inn.nextLine().split(" ");
        int row = Integer.parseInt(size[0]);
        int column = Integer.parseInt(size[1]);
        int[][] matrix = new int[row][column];
        int[][] rotatedMatrix = new int[row][column];

        for (int i = 0; i < row ; i++) {
            String[] nums = inn.nextLine().split(" ");
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Integer.parseInt(nums[j]);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                rotatedMatrix[j][row - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < column ; j++) {
                System.out.print(rotatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
