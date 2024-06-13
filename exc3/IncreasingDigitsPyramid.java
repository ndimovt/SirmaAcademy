package io.github.ndimovt.exc3;

import java.util.Scanner;

public class IncreasingDigitsPyramid {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int height = inn.nextInt();
        drawPyramid(height);
    }
    private static void drawPyramid(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j <= 2 * i - 1; j++) {
                System.out.print(j);
            }
            for (int j = 2 * i - 2; j >= i; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
