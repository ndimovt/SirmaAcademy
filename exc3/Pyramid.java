package io.github.ndimovt.exc3;

import java.util.Scanner;

public class Pyramid {
    private static final Scanner inn = new Scanner(System.in);
    
    public static void main(String[] args) {
        int num = inn.nextInt();
        print(num);
    }
    public static void print(int n){
        int currentNumber = 1;
        for (int i = 1; currentNumber <= n; i++) {
            for (int j = 1; j <= i && currentNumber <= n; j++) {
                System.out.print(currentNumber);
                if (j < i) {
                    System.out.print(" ");
                }
                currentNumber++;
            }
            System.out.println();
        }
    }
}
