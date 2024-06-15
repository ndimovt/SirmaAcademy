package io.github.ndimovt.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ListOfProducts {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String product = inn.nextLine();
        String[] arr = product.split(" ");
        int count = 1;
        Arrays.sort(arr);
        for(String word : arr){
            System.out.printf("%d.%s\n",count++,word);
        }
    }
}
