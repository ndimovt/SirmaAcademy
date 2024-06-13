package io.github.ndimovt.exc2;

import java.util.Scanner;

public class EvenOrOdd {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = inn.nextInt();
        System.out.println(evenOrOdd(num));
    }
    public static String evenOrOdd(int number){
        if(number % 2 == 0){
            return "even";
        }
        return "odd";
    }

}
