package io.github.ndimovt.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ReplaceRepeatingChars {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Set<String> noDuplication = new HashSet<>();
        String word = inn.nextLine();
        char[] arr = word.toCharArray();
        for(char a : arr){
            noDuplication.add(String.valueOf(a));
        }
        noDuplication.forEach(System.out::print);

    }
}
