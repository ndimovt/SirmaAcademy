package io.github.ndimovt.loops;

import java.util.Scanner;

public class SumOfVowels {
    private static final Scanner inn = new Scanner(System.in);
    public static void main(String[] args) {
        String word = inn.nextLine();
        System.out.println(sumVowels(word));
    }
    private static int sumVowels(String wordToCheck){
        int sum = 0;
        char[] arr = wordToCheck.toCharArray();
        for(char a : arr){
            if(a == 'a'){
                sum += 1;
            } else if (a == 'e') {
                sum += 2;
            } else if (a == 'i') {
                sum += 3;
            } else if (a == 'o') {
                sum += 4;
            } else if (a == 'u') {
                sum += 5;
            }
        }
        return sum;
    }
}
