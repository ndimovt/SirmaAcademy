package io.github.ndimovt.exc4;

import java.util.Scanner;

public class RevStringArray {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String word = inn.nextLine();
        String[] toBeReversed = word.split(" ");
        reversedArr(toBeReversed);
    }
    private static void reversedArr(String[] arr){
        StringBuilder sb = new StringBuilder();
        for (String a : arr) {
            sb.append(a).append(" ");
        }
        System.out.println(sb.reverse());
    }
}
