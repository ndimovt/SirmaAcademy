package io.github.ndimovt.exc3;

import java.util.Scanner;

public class ArmstrongNum {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int number = inn.nextInt();
        if (isArmstrong(number)) {
            System.out.println("Armstrong number");
        } else {
            System.out.println("Not Armstrong");
        }
    }
    public static boolean isArmstrong(int number) {
        int originalNumber, remainder, result = 0, n = 0;
        originalNumber = number;
        for (originalNumber = number; originalNumber != 0; originalNumber /= 10, ++n);
        originalNumber = number;
        while (originalNumber != 0) {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, n);
            originalNumber /= 10;
        }
        if (result == number) {
            return true;
        }
        return false;
    }
}
