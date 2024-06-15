package io.github.ndimovt.loops;

import java.util.Scanner;

public class HalfRombus {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = inn.nextInt();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < i ; j++) {
                System.out.print("* ");
            }
            System.out.println("*");
        }
    }
}
