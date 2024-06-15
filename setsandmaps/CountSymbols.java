package io.github.ndimovt.setsandmaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class CountSymbols {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        List<Character> symbols = new ArrayList<>();
        Map<Character, Integer> result = new TreeMap<>();
        String word = inn.nextLine();
        char[] arr = word.toCharArray();
        for(char a : arr){
            symbols.add(a);
        }
        for(char s : symbols){
            result.put(s, result.getOrDefault(s, 0) + 1);
        }
        result.forEach((k,v) -> System.out.println(k +": "+v));
    }
}
