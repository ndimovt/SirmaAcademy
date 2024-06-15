package io.github.ndimovt.loops;

import java.util.Scanner;

public class TreePattern {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = inn.nextInt();
        print(num);
    }
    public static void print(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        if (n % 2 == 0) {
            for (int i = 0; i <= n / 2 + 1; i++) {
                System.out.print(" ");
                if (i == n / 2 + 1) {
                    System.out.print("*");
                }
            }
        } else {
            for (int i = 0; i <= n / 2 + 1; i++) {
                System.out.print(" ");
                if (i == n / 2 + 1) {
                    System.out.print("*");
                }
            }
        }
    }
}


