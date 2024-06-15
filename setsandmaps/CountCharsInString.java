package io.github.ndimovt.exc9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class CountCharsInString {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        List<Character> symbols = new ArrayList<>();
        Map<Character, Integer> result = new TreeMap<>();
        String word = inn.nextLine();
        char[] arr = word.toCharArray();
        for(char a : arr) {
            if (a != ' ') {
                symbols.add(a);
            }
        }
        for(char s : symbols){
            result.put(s, result.getOrDefault(s, 0) + 1);
        }
        result.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).
                forEach(entry -> System.out.println(entry.getKey() + " -> "+entry.getValue()));
    }
}
