package io.github.ndimovt.loops;

import java.util.Scanner;

public class ReverseOrder {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = inn.nextInt();
        for (int i = num; i >=0 ; i--) {
            System.out.println(i);
        }
    }
}
