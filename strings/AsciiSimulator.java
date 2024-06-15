package io.github.ndimovt.strings;

import java.util.Scanner;

public class AsciiSimulator {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int sum = 0;
        char start = inn.nextLine().charAt(0);
        char end = inn.nextLine().charAt(0);
        String word = inn.nextLine();
        char[] arr = word.toCharArray();
        for (int i = start+1; i < end; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] == i){
                    sum += i;
                }
            }
        }
        System.out.println(sum);
    }
}
