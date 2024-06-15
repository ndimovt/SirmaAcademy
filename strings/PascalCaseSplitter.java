package io.github.ndimovt.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PascalCaseSplitter {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Pattern p = Pattern.compile("[A-Z][a-z]+");
        String input = inn.nextLine();
        Matcher m = p.matcher(input);
        while(m.find()){
            System.out.print(m.group() + ", ");

        }
    }
}
