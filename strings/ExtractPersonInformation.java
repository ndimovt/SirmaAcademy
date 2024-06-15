package io.github.ndimovt.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExtractPersonInformation {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Integer> nameAge = new HashMap<>();
        int count = inn.nextInt();
        inn.nextLine();
        for (int i = 0; i < count; i++) {
            String word = inn.nextLine();
            String name = word.substring(word.indexOf('@'), word.indexOf('|')).replace("@", "");
            String age = word.substring(word.indexOf('#'), word.indexOf('*')).replace("#", "");
            nameAge.put(name, Integer.parseInt(age));
        }
        nameAge.forEach((k,v) -> System.out.printf("%s is %d years old.\n", k, v));
    }
}
