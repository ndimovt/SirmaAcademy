package io.github.ndimovt.conditionalstatements;

import java.util.Scanner;

public class Alarm {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int hour = inn.nextInt();
        int minute = inn.nextInt();
        afterFifteenMins(hour, minute);

    }
    public static void afterFifteenMins(int hour, int min){
        int totalMinutes = hour * 60 + min;
        totalMinutes += 15;
        int newHour = totalMinutes / 60;
        int newMinute = totalMinutes % 60;
        String formattedHour = String.format("%d", newHour);
        String formattedMinute = String.format("%02d", newMinute);
        System.out.println(formattedHour + ":" + formattedMinute);
    }
}
