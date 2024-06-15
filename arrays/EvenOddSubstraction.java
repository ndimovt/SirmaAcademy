package io.github.ndimovt.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EvenOddSubstraction {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String word = inn.nextLine();
        String[] toBeReversed = word.split(" ");
        System.out.println(sumOfEven(toBeReversed));
    }
    private static int sumOfEven(String[] arr){
        int [] nums = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        int sumEven = 0;
        int sumOdd = 0;
        for(int a : nums){
            if(a % 2 == 0){
                sumEven += a;
            }else{
                sumOdd += a;
            }
        }
        return sumEven - sumOdd;
    }
}
