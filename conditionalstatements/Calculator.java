package io.github.ndimovt.conditionalstatements;

import java.util.Scanner;

public class Calculator {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        double first = inn.nextDouble();
        double second = inn.nextDouble();
        inn.nextLine();
        String word = inn.nextLine();
        System.out.println(result(first, second, word));
    }
    public static double result(double num1, double num2, String action){
        switch (action){
            case "add":
                return num1 + num2;
            case "subtract":
                return num1 - num2;
            case "divide":
                if(num1 == 0 || num2 ==0){
                    throw new IllegalArgumentException("Can not divide by 0!");
                }else {
                    return num1 / num2;
                }
            case "multiply":
                return num1 * num2;
        }
        return 0.0;
    }
}
