package io.github.ndimovt.introduction;

import java.util.Scanner;

public class Office {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        double costForTheFirstCabinet = inn.nextDouble();
        System.out.println(cost(costForTheFirstCabinet));
    }
    public static String cost(double price){
        double second = price - (price*0.2);
        double third = (price + second) + ((price + second)*0.15);
        double total = price + second + third;
        return String.format("%.3f", total);
    }
}
