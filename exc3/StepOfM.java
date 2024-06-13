package io.github.ndimovt.exc3;

import java.util.Scanner;

public class StepOfM {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = inn.nextInt();
        int step = inn.nextInt();
        for (int i = 1; i <=num ; i+=step) {
            System.out.println(i);
        }
    }
}
