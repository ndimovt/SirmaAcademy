package io.github.ndimovt.conditionalstatements;

import java.util.Scanner;

public class FigureFace {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String figure = inn.nextLine();
        switch (figure){
            case "rectangle":
                System.out.printf("%.2f",rectangle());
                break;
            case "square":
                System.out.printf("%.2f",square());
                break;
            case "triangle":
                System.out.printf("%.2f",triangle());
                break;
            case "circle":
                System.out.printf("%.2f",circle());
                break;
            default:
                break;
        }
    }
    public static double rectangle(){
        double firstSide = inn.nextDouble();
        double secondSide = inn.nextDouble();
        return firstSide * secondSide;
    }
    public static double square(){
        double side = inn.nextDouble();
        return Math.pow(side, 2.0);
    }
    public static double triangle(){
        double side = inn.nextDouble();
        double height = inn.nextDouble();
        return side * height;
    }
    public static double circle(){
        double radius = inn.nextDouble();
        return Math.PI * Math.pow(radius, 2.0);
    }
}
