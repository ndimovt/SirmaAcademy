package io.github.ndimovt.exc1;

import java.util.Scanner;

public class Circle {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int radius = inn.nextInt();
        System.out.printf("%.2f", radius(radius));
    }
    public static double radius(int r){
        return 2 * Math.PI * r;
    }
}
