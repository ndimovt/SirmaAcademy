package io.github.ndimovt.exc2;

import java.util.Scanner;

public class ClimateZone {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        double coordinates = inn.nextDouble();
        inn.nextLine();
        String direction = inn.nextLine();
        if (coordinates >= -90.0 && coordinates <= 90.0) {
            if (coordinates > 66.5 && (direction.equals("N"))) {
                System.out.println("Arctic zone");
            } else if (coordinates > 23.5 && (direction.equals("N") || direction.equals("S"))) {
                System.out.println("Temperate zone");
            } else if (coordinates > 0 && (direction.equals("N") || direction.equals("S"))) {
                System.out.println("Tropic zone");
            } else if (coordinates == 0) {
                System.out.println("Equator");
            } else if (coordinates < -66.5 && (direction.equals("S") || direction.equals("N"))) {
                System.out.println("Arctic zone");
            } else if (coordinates < -23.5 && (direction.equals("S") || direction.equals("N"))) {
                System.out.println("Temperate zone");
            }
        }
    }
}
