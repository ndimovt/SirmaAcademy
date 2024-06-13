package io.github.ndimovt.exc3;

import java.util.Scanner;

public class Factorial {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int number = inn.nextInt();
        System.out.println(factorial(number));
    }
    public static int factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return n * factorial(n - 1);
    }
}
