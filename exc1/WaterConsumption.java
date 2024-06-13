package io.github.ndimovt.exc1;

import java.util.Scanner;

public class WaterConsumption {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int total = inn.nextInt();
        int persons = inn.nextInt();
        System.out.printf("%.2f", waterPerPerson(total, persons));
    }
    public static double waterPerPerson(int water, int persons){
        return water / 7.0 / persons;
    }
}
