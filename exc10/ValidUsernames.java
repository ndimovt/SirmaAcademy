package io.github.ndimovt.exc10;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String[] usernames = inn.nextLine().split(", ");
        for (String name : usernames) {
            Pattern p = Pattern.compile("^[\\dA-Za-z\\_\\-]+");
            Matcher m = p.matcher(name);
            while(m.find()){
                if(m.group().length() >= 3 && m.group().length() <= 16){
                    System.out.println(m.group());
                }
            }
        }
    }
}
