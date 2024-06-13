package io.github.ndimovt.exc2;

import java.util.Scanner;

public class Marks {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        double mark = inn.nextDouble();
        word(mark);

    }
    public static void word(double number){
        if(number >= 5.50 && number <= 6.00){
            System.out.println("Excellent!");
        }
    }
}
