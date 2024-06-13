package io.github.ndimovt.exc3;

import java.util.Scanner;

public class LeftArrowPattern {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = inn.nextInt();
        print(num);
    }
    public static void print(int n){
        for (int i = 0; i < n ; i++) {
            for (int j = n-i; j >= 0 ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n-i; j >= 0 ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
