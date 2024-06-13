package io.github.ndimovt.exc3;

import java.util.Scanner;

public class HousePattern {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int houseHeight = inn.nextInt();
        drawHouse(houseHeight);
    }
    public static void drawHouse(int n){
        if(n % 2 != 0){
            for (int i = 1; i <=n ; i+=2) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }

        }else{
            for (int i = 2; i <=n ; i+=2) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j < n ; j++) {
                if(j==0 || j == n-1) {
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
