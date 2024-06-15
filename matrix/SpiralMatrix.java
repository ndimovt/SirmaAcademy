package io.github.ndimovt.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String[] size = inn.nextLine().split(" ");
        int row = Integer.parseInt(size[0]);
        int column = Integer.parseInt(size[1]);
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            String[] element = inn.nextLine().split(" ");
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Integer.parseInt(element[j]);
            }
        }
        System.out.println(spiralReading(matrix));
    }
    private static List<Integer> spiralReading(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        int rowBeg = 0;
        int rowEnd = matrix.length - 1;
        int colBeg = 0;
        int colEnd = matrix[0].length - 1;

        while(rowBeg <= rowEnd && colBeg <= colEnd){
            for (int i = colBeg; i <= colEnd; i++) {
                result.add(matrix[rowBeg][i]);
            }
            rowBeg++;
            for (int i = rowBeg; i <= colEnd; i++) {
                result.add(matrix[i][rowEnd]);
            }
            colEnd--;
            if(rowEnd >= rowBeg){
                for (int i = colEnd; i >= colBeg; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            if(colEnd >= colBeg){
                for (int i = rowEnd; i >= rowBeg; i--) {
                    result.add(matrix[i][colBeg]);
                }
                colBeg++;
            }
        }
        return result;
    }
}
