package io.github.ndimovt.exc1;

import java.util.Scanner;

public class Time {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int minutes = inn.nextInt();
        hoursAndMinutes(minutes);
    }
    private static void hoursAndMinutes(int mins){
        int hours = mins / 60;
        int minute = mins % 60;
        System.out.println(hours > 9? hours + ":"+minute : "0"+hours+":"+minute);
    }
}
