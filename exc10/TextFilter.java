package io.github.ndimovt.exc10;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFilter {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String[] sub = inn.nextLine().split(", ");
        String word = inn.nextLine();
        for (int i = 0; i < sub.length; i++) {
            Pattern p = Pattern.compile(sub[i]);
            Matcher m = p.matcher(word);
            while(m.find()){
                word = word.replaceAll(sub[i],"*".repeat(sub[i].length()));
            }
        }
        System.out.println(word);
    }

}
