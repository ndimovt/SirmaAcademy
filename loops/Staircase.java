package io.github.ndimovt.loops;

import java.util.Scanner;

public class Staircase {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int stairs = inn.nextInt();
        drawStairs(stairs);
    }
    private static void drawStairs(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 3; j <i+1 ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
