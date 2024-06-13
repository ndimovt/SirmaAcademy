package io.github.ndimovt.exc3;

import java.util.Scanner;

public class Arrow {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int arrow = inn.nextInt();
        print(arrow);
    }
    private static void print(int n){
        for (int i = 0; i <n ; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n/2 ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <n-1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
