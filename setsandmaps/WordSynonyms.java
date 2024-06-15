package io.github.ndimovt.setsandmaps;

import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class WordSynonyms{
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, ArrayList<String>> synonyms = new LinkedHashMap<>();
        int words = inn.nextInt();
        inn.nextLine();
        for (int i = 0; i < words; i++) {

            String word = inn.nextLine();
            String synonym = inn.nextLine();

            synonyms.computeIfAbsent(word, k -> new ArrayList<>()).add(synonym);
        }
        for(Map.Entry<String, ArrayList<String>> entry : synonyms.entrySet()){
            System.out.print(entry.getKey() + " - ");
            System.out.println(String.join(", ", entry.getValue()));
        }
    }
}

