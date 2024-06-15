package io.github.ndimovt.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class FirstAndLastKNums {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int count = 0;
        int n = inn.nextInt();
        inn.nextLine();
        String element = inn.nextLine();
        String[] arr = element.split(" ");
        int[] result = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < result.length ; i++) {
            System.out.print(result[i]+" ");
            count++;
            if(count == n){
                break;
            }
        }
        System.out.println();
        for (int i = result.length - n; i < result.length ; i++) {
            System.out.print(result[i]+" ");
        }

    }
}
