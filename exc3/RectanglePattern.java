package io.github.ndimovt.exc3;

import java.util.Scanner;

public class RectanglePattern {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int sideA = inn.nextInt();
        int sideB = inn.nextInt();
        printRectangle(sideA, sideB);

    }
    public static void printRectangle(int a, int b){
        for (int i = 1; i <= a ; i++) {
            for (int j = 1; j <= b; j++) {
                if(i == 1 || i == a || j == 1 || j == b){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
