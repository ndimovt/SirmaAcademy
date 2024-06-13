package io.github.ndimovt.exc4;

import java.util.Scanner;

public class PrintNthElement {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String element = inn.nextLine();
        String[] arr = element.split(" ");
        int n = inn.nextInt();
        for (int i = 0; i < arr.length ; i+= n) {
            System.out.print(arr[i]+ " ");
        }
    }
}
