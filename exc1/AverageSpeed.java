package io.github.ndimovt.exc1;

import java.util.Scanner;

public class AverageSpeed {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        double distance = inn.nextInt();
        double time = inn.nextInt();
        System.out.printf("%.2f", speed(distance, time));
    }
    public static double speed(double distance, double time){
        return distance / time;
    }
}
