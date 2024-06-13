package io.github.ndimovt.exc3;

import java.util.Scanner;

public class SquarePattern {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = inn.nextInt();
        print(n);
    }
    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1) {
                    if (j == 0 || j == n - 1) {
                        System.out.print("+");
                    } else {
                        System.out.print("-");
                    }
                } else {
                    if (j == 0) {
                        System.out.print("|");
                    } else if (j == n - 1) {
                        System.out.print("|");
                    } else {
                        System.out.print("-");
                    }
                }
            }
            System.out.println();
        }
    }
}
