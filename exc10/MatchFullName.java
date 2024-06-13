package io.github.ndimovt.exc10;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Pattern p = Pattern.compile("^[A-Z][a-z]+ [A-Z][a-z]+$");
        String[] input = inn.nextLine().split(", ");
        for(String s : input) {
            Matcher m = p.matcher(s);
            while(m.find()){
                System.out.print(m.group() + " ");
            }
        }
    }
}
