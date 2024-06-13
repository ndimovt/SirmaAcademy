package io.github.ndimovt.exc3;

import java.util.Scanner;

public class UniqueCodes {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int firstNum = 0;
        int secondNum = 0;
        int thirdNum = 0;
        do {
            System.out.println("Enter first num");
            firstNum = inn.nextInt();
        } while (firstNum < 1 || firstNum > 9);
        do {
            System.out.println("Enter second num");
            secondNum = inn.nextInt();
        } while (secondNum < 1 || secondNum > 9);
        do {
            System.out.println("Enter third num");
            thirdNum = inn.nextInt();
        } while (thirdNum < 1 || thirdNum > 9);
        printCodes(firstNum, secondNum, thirdNum);

    }

    public static void printCodes(int num1, int num2, int num3) {
        for (int i = 2; i <= num1; i += 2) {
            for (int j = 2; j <= num2; j++) {
                if (isPrime(j)) {
                    for (int k = 2; k <= num3; k += 2) {
                        int code = i * 100 + j * 10 + k;
                        System.out.println(code);
                    }
                }
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
