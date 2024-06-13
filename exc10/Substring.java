package io.github.ndimovt.exc10;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Substring {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String sub = inn.nextLine();
        String word = inn.nextLine();
        Pattern p = Pattern.compile(sub);
        Matcher m = p.matcher(word);
        while(m.find()){
            word = word.replaceAll(sub,"");
        }
        System.out.println(word);
    }
}
