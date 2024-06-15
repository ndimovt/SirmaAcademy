package io.github.ndimovt.introduction;

import java.util.Scanner;

public class Speed {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int distance = inn.nextInt();
        int hours = inn.nextInt();
        int minutes = inn.nextInt();
        int seconds = inn.nextInt();
        double time = secondsConverter(hours, minutes, seconds);
        System.out.println(speed(distance, time));
    }
    public static double secondsConverter(int hours, int minutes, int seconds){
        double hoursToSec = hours * 3600.0;
        double minsToSec = minutes * 60.0;
        return hoursToSec + minsToSec + seconds;
    }
    public static double speed (int distance, double time){
        return distance / time;
    }
}
