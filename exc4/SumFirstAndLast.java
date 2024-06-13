package io.github.ndimovt.exc4;

import java.util.Scanner;

public class SumFirstAndLast {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String element = inn.nextLine();
        String[] arr = element.split(" ");
        System.out.println(sum(arr));
    }
    private static int sum(String[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length ; i++) {
            sum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[arr.length - 1]);
        }
        return sum;
    }
}
