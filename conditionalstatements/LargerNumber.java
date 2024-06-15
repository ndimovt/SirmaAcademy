package io.github.ndimovt.conditionalstatements;

import java.util.Scanner;

public class LargerNumber {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int numOne = inn.nextInt();
        int numTwo = inn.nextInt();
        System.out.println(higher(numOne, numTwo));
    }
    public static int higher (int first, int second){
        return Math.max(first, second);
    }
}
