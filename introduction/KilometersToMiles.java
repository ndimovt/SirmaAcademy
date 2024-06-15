package io.github.ndimovt.introduction;

import java.util.Scanner;

public class KilometersToMiles {
    private static Scanner inn = new Scanner(System.in);
    public static void main(String[] args) {
        int kilometers = inn.nextInt();
        mileConv(kilometers);
    }
    private static void mileConv(int toConvert){
        double miles = toConvert * 0.621371192;
        System.out.println(miles);
    }
}