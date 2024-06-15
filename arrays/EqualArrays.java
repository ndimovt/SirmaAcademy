package io.github.ndimovt.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String populateFirst = inn.nextLine();
        String[] first = populateFirst.split(" ");
        String populateSecond = inn.nextLine();
        String[] second = populateSecond.split(" ");
        result(first, second);

    }
    private static boolean isTrue(String[] arr1, String[] arr2){
        return Arrays.equals(arr1,arr2);
    }
    private static void result(String[] first, String[] second){
        if(isTrue(first, second)){
            int sum = 0;
            int[] arr = Arrays.stream(first).mapToInt(Integer::parseInt).toArray();
            for(int a : arr){
                sum += a;
            }
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }else{
            int result = -1;
            for (int i = 0; i < first.length ; i++) {
                    if (!first[i].equals(second[i])) {
                        result = i;
                        break;
                    }
                }
            System.out.printf("Arrays are not identical. Found difference at %d index",result );
        }
    }
}
