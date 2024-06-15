package io.github.ndimovt.introduction;

import java.util.Scanner;

public class Calculator {
    private static Scanner inn = new Scanner(System.in);
    public static void main(String[] args) {
        int numOne = inn.nextInt();
        int numTwo = inn.nextInt();
        calculations(numOne,numTwo);
    }
    private static void calculations(int numberOne, int numberTwo){
        System.out.println("The sum is "+(numberOne + numberTwo));
        System.out.println("The difference is " +(numberOne - numberTwo));
        System.out.println("The product is "+(numberOne * numberTwo));
        double average = (numberOne + numberTwo) / 2.00;
        System.out.println("The average is "+average);
    }
}
