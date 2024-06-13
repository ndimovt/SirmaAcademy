package io.github.ndimovt.exc10;

import java.util.Scanner;

public class RepeatStrings {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String[] arr = inn.nextLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            int length = arr[i].length();
            for (int j = 0; j < length ; j++) {
                sb.append(arr[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
