package io.github.ndimovt.introduction;

import java.util.Scanner;

public class BMI {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int weight = inn.nextInt();
        double height = inn.nextDouble();
        System.out.printf("%.2f",bodyMassIndex(weight, height));
    }
    public static double bodyMassIndex(int weight, double height){
        return weight / Math.pow(height,2);
    }
}
