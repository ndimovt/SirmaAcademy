package io.github.ndimovt.introduction;

import java.util.Scanner;

public class Painting {
    private static final Scanner inn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = inn.nextInt();
        System.out.println(paintQuantity(n));

    }
    public static String paintQuantity(int totalPaint){
        String red = String.format("Red: %.4f\n",totalPaint/13.0);
        String yellow = String.format("Yellow: %.4f\n",4*(totalPaint / 13.0));
        String white = String.format("White: %.4f", 8*(totalPaint / 13.0));
        return red + yellow + white;
    }
}
