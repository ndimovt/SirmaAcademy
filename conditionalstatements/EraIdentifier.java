package io.github.ndimovt.conditionalstatements;

import java.util.Scanner;

public class EraIdentifier {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int year = inn.nextInt();
        inn.nextLine();
        String material = inn.nextLine();
        System.out.println(period(year, material));
    }
    public static String period(int year, String material){
        if(year < 500 && material.equalsIgnoreCase("stone")){
            return "Ancient";
        } else if (year >= 500 && year <= 1500 && material.equalsIgnoreCase("stone")) {
            return "Medieval";
        } else if (year >= 1500 && year < 1800 && material.equalsIgnoreCase("wood")) {
            return "Colonial";
        } else if (year >= 1800 && year < 1900 && material.equalsIgnoreCase("steel")) {
            return "Industrial";
        } else if (year >= 1900 && material.equalsIgnoreCase("steel")) {
            return "Modern";
        }
        return "Uncertain";
    }
}
