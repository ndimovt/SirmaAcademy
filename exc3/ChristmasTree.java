package io.github.ndimovt.exc3;

import java.util.Scanner;

public class ChristmasTree {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = inn.nextInt();
        print(n);
    }
    public static void print(int n) {
        for (int i = 0; i < n+2 ; i++) {
            System.out.print(" ");
            if(i == n+1){
                System.out.print("|");
                break;
            }
        }
        System.out.println();
        for (int i = 0; i < n ; i++) {
            for (int j = n-i; j >= 0 ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i ; j++) {
                System.out.print("*");
            }
            for (int j = n; j < n+1 ; j++) {
                System.out.print("|");
            }
            for (int j = 0; j < i+1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
