package io.github.ndimovt.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNum {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String element = inn.nextLine();
        String[] arr = element.split(" ");
        System.out.println(result(arr));
    }
    private static int result(String[] array){
        int[] numArr = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();
        while (numArr.length > 1) {
            int[] condensedArray = new int[numArr.length - 1];
            for (int i = 0; i < numArr.length - 1; i++) {
                condensedArray[i] = numArr[i] + numArr[i + 1];
            }
            numArr = condensedArray;
        }
        return numArr[0];
    }

}
