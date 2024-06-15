package io.github.ndimovt.introduction;

import java.util.Scanner;

public class ElectricityBill {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfUnits = inn.nextInt();
        double rate = inn.nextDouble();
        System.out.printf("%.2f", bill(numberOfUnits, rate));
    }
    public static double bill(int units, double rate){
        return units * rate + 10;
    }
}
