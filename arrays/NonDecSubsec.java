package io.github.ndimovt.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class NonDecSubsec {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int max = 0;
        String element = inn.nextLine();
        String[] arr = element.split(" ");
        int [] nums = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        for (int num : nums) {
            if (num > max) {
                System.out.print(num + " ");
                max = num;
            }
        }
    }
}
