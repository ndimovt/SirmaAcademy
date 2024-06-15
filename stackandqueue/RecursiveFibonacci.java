package io.github.ndimovt.stackandqueue;

import java.util.Scanner;

public class RecursiveFibonacci {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int number = inn.nextInt();
        System.out.println(fibonacciSum(number));
    }
    private static long fibonacciSum(int n){
        if(n <= 1){
            return n;
        }else {
            return fibonacciSum(n - 1) + fibonacciSum(n - 2);
        }
    }
}
