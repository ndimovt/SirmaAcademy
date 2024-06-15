package io.github.ndimovt.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class RevArrayOfNumbers {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = inn.nextInt();
        inn.nextLine();
        String element = inn.nextLine();
        String[] array = element.split(",");
        int[] result = reversed(n, array);
        for (int i = result.length-1; i >= 0 ; i--) {
            System.out.print(result[i]+" ");
        }
    }
    private static int[] reversed(int n, String[] arr){
        int[] nElement = new int[n];
        int[] backupArr = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < backupArr.length - (arr.length - n) ; i++) {
            nElement[i] = backupArr[i];
        }
        return nElement;
    }
}
