package io.github.ndimovt.exc10;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\+359([ -])2\\1\\d{3}\\1\\d{4}$");
        String[] phones = inn.nextLine().split(",");
        for(String s : phones){
            Matcher m = p.matcher(s);
            while(m.find()){
                System.out.print(m.group()+", ");
            }
        }
    }
}
