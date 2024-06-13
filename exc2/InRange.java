package io.github.ndimovt.exc2;

import java.util.Scanner;

public class InRange {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = inn.nextInt();
        System.out.println(range(num));
    }
    public static String range(int number){
        if(number >= -100 && number <= 100 && number != 0){
            return "Yes";
        }else {
            return "No";
        }
    }
}
