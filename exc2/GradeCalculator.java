package io.github.ndimovt.exc2;

import java.util.Scanner;

public class GradeCalculator {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int percentage = inn.nextInt();
        System.out.println(symbol(percentage));
    }
    public static char symbol(int percent){
        if(percent <101 && percent >= 90){
            return 'A';
        } else if (percent < 90 && percent >= 80) {
            return 'B';
        } else if (percent <= 79 && percent >= 70) {
            return 'C';
        } else if (percent <= 69 && percent >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
