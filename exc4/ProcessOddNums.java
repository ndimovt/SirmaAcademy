package io.github.ndimovt.exc4;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class ProcessOddNums{
    private static Scanner inn = new Scanner(System.in);
    public static void main(String[] args) {
        String element = inn.nextLine();
        String[] array = element.split(" ");
        result(array);
    }
    private static void result(String[] arr){
        ArrayList<Integer> reversed = new ArrayList<>();
        int[] result = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        for(int i = 0; i < result.length; i++){
            if(i % 2 != 0){
                reversed.add(result[i] * 2);
            }
        }
        for(int i = reversed.size()-1; i >= 0; i--){
            System.out.print(reversed.get(i) + " ");
        }
    }

}
