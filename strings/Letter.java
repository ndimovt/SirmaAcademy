package io.github.ndimovt.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Letter {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String text = inn.nextLine();
        String[] word = inn.nextLine().split(", ");
        List<String> result = new ArrayList<>(Arrays.asList(word));
        Pattern p = Pattern.compile("_+");
        Matcher m = p.matcher(text);
        StringBuilder sb = new StringBuilder();

        while (m.find()) {
            boolean found = false;
            for (String s : result) {
                if (m.group().length() == s.length()) {
                    m.appendReplacement(sb, s);
                    result.remove(s);
                    found = true;
                    break;
                }
            }
            if (!found) {
                m.appendReplacement(sb, m.group());
            }
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
