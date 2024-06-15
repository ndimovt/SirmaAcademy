package io.github.ndimovt.introduction;

import java.util.Scanner;

public class FuelConsumption {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        double distance = inn.nextInt();
        double consumption = inn.nextInt();
        System.out.printf("%.2f", fuelEfficiency(distance, consumption));
    }
    public static double fuelEfficiency(double distance, double consumption){
        return distance / consumption;
    }
}
