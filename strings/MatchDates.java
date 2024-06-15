package io.github.ndimovt.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Pattern p = Pattern.compile("(?<day>\\d{2})(?<separator>[./-])(?<month>[A-Z][a-z]{2})\\k<separator>(?<year>\\d{4})");
        String[] arr = inn.nextLine().split(", ");
        for(String s : arr){
            Matcher m = p.matcher(s);
            while (m.find()) {
                String day = m.group("day");
                String month = m.group("month");
                String year = m.group("year");

                System.out.printf("Day: %s, Month: %s, Year: %s\n",day, month, year);
            }
        }
    }
}
