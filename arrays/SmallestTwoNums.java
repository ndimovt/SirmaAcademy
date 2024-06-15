package io.github.ndimovt.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestTwoNums {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int count = 0;
        String element = inn.nextLine();
        String[] arr = element.split(" ");
        int[] result = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(result);
        for (int i = 0; i < result.length ; i++) {
            System.out.print(result[i]+" ");
            count++;
            if(count == 2){
                break;
            }
        }
    }
}
