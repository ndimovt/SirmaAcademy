package io.github.ndimovt.setsandmaps;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class OddOccurrences{
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Set<String> oddWords = new HashSet<>();
        String[] arr = inn.nextLine().split(" ");
        for(String s : arr){
            String a = null;
            int count = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i].equalsIgnoreCase(s)){
                    count++;
                    a = arr[i];
                }
            }
            if(count % 2 != 0){
                oddWords.add(a);
            }
        }
        for(String a : oddWords){
            System.out.print(a.toLowerCase()+", ");
        }
    }
}
