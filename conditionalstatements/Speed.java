package io.github.ndimovt.conditionalstatements;

import java.util.Scanner;

public class Speed {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int speed = inn.nextInt();
        System.out.println(information(speed));

    }
    public static String information(int number){
        if(number <= 10){
            return "slow";
        } else if (number <= 60) {
            return "average";
        } else if (number <= 120) {
            return "fast";
        } else if (number <= 160) {
            return "super-fast";
        }
        return "turbo-fast";
    }
}
