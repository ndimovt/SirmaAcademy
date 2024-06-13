package io.github.ndimovt.exc2;

import java.util.Scanner;

public class LeapYear {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int year = inn.nextInt();
        System.out.println(checkYear(year));
    }
    public static String checkYear(int year){
        if(year % 4 == 0 && year % 100 == 0 && year % 400 == 0){
            return "It's a leap year!";
        }
        return "It's not a leap year!";
    }
}
