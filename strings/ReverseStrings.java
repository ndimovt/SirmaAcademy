package io.github.ndimovt.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReverseStrings {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, String> reversed = new HashMap<>();
        while(true){
            String word = inn.nextLine();
            if(word.equalsIgnoreCase("end")){
                break;
            }else{
                reversed.put(word, reverse(word));
            }
        }
        reversed.forEach((k,v) -> System.out.println(k+" = "+v));
    }
    private static String reverse(String toRev){
        StringBuilder as = new StringBuilder(toRev);
        return as.reverse().toString();
    }
}
