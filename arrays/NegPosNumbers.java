package io.github.ndimovt.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NegPosNumbers {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String element = inn.nextLine();
        String[] arr = element.split(" ");
        Integer[] result = negativeOrdered(arr);
        for(int a : result){
            System.out.println(a);
        }
    }
    private static Integer[] negativeOrdered(String[] array){
        int[] ord = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> positive = new ArrayList<>();
        for(int a:ord){
            if(a < 0){
                negative.add(a);
            }else{
                positive.add(a);
            }
        }
        ArrayList<Integer> result = new ArrayList<>(negative);
        result.addAll(positive);
        Integer[] res = new Integer[result.size()];
        res = result.toArray(res);
        return res;
    }
}
