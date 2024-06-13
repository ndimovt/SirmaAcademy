package io.github.ndimovt.exc7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchingBrackets {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Deque<String> result = new ArrayDeque<>();
        String number = inn.nextLine();
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(number);
        while(matcher.find()){
            result.push(matcher.group());
        }
        while(!result.isEmpty()){
            System.out.println(result.pop());
        }
    }
}
