package io.github.ndimovt.arrays;

import java.util.Scanner;
import java.util.Arrays;

public class LongestSeqIdenticalElements{
    private static Scanner inn = new Scanner(System.in);
    public static void main(String[] args) {
        String element = inn.nextLine();
        String[] array = element.split(" ");
        longestSequenceOfElements(array);
    }
    private static void longestSequenceOfElements(String[] arr){
        int currentSeq = 1;
        int longestSeq = 0;
        int element = 0;
        int[] result = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        for(int i = 1; i <= result.length - 1; i++){
            if(result[i] == result[i-1]){
                currentSeq++;
                if(currentSeq > longestSeq){
                    longestSeq = currentSeq;
                    element = result[i];
                }
            }else{
                currentSeq = 1;
            }
        }
        for(int i = 0; i < longestSeq; i++){
            System.out.print(element + " ");
        }
    }
}
