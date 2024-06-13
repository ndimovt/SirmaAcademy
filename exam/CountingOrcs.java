package io.github.ndimovt.exam;

import java.util.Scanner;

public class CountingOrcs {

    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);
        int totalOrcs = 0;
        int n = inn.nextInt();
        int m = inn.nextInt();
        int h = inn.nextInt();
        for (int i = 0; i < h ; i++) {
            totalOrcs += n + (m * i);
        }
        System.out.println(totalOrcs);
    }
}
