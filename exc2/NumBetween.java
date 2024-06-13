package io.github.ndimovt.exc2;

import java.util.Scanner;

public class NumBetween {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = inn.nextInt();
        System.out.println(numWithWord(num));
    }
    public static String numWithWord(int number){
        switch (number){
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "too big";
        }
    }
}
