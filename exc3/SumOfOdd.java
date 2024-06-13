package io.github.ndimovt.exc3;

import java.util.Scanner;

public class SumOfOdd {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = inn.nextInt();
        int sum = 0;
        int odd = 0;
        for (int i = 0; i < num ; i++) {
            odd = 2 * i +1;
            System.out.println(odd);
            sum += odd;
        }
        System.out.printf("Sum: %d\n", sum);
    }
}
