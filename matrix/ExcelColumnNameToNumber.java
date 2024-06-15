package io.github.ndimovt.matrix;

import java.util.Scanner;

public class ExcelColumnNameToNumber {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String letter = inn.nextLine().toUpperCase();
        int sum = 0, value = 0;
        for (int i = 0; i < letter.length() ; i++) {
            char symbol = letter.charAt(i);
            value = symbol - 'A' + 1;
            sum = sum*26+value;
        }
        System.out.println(sum);
    }
}
