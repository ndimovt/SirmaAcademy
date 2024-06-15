package io.github.ndimovt.loops;

import java.util.Scanner;

public class AlternativeConditions {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = inn.nextInt();
        print(num);
    }
    public static void print(int n){
        int number = 0;
        main_loop:
        for (int i = 0; i < n ; i++) {
            for (int j = n-i; j >= 0 ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i ; j++) {
                number++;
                System.out.print(number);
                if(number == n){
                    break main_loop;
                }
            }
            System.out.println();
        }
    }
}
