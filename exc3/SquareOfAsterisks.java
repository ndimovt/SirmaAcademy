package io.github.ndimovt.exc3;

import java.util.Scanner;

public class SquareOfAsterisks {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int side = inn.nextInt();
        generateSquare(side);
    }
    public static void generateSquare(int n) {
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
