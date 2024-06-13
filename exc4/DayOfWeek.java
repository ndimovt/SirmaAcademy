package io.github.ndimovt.exc4;

import java.util.HashMap;
import java.util.Scanner;

public class DayOfWeek {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<Integer, String> week = new HashMap<>();
        week.put(1, "Monday"); week.put(2, "Tuesday"); week.put(3, "Wednesday"); week.put(4, "Thursday");
        week.put(5, "Friday"); week.put(6, "Saturday"); week.put(7, "Sunday");
        int n = inn.nextInt();
        System.out.println(day(n,week));
    }
    private static String day(int num, HashMap<Integer, String> map){
        if(map.get(num) != null) {
            return map.get(num);
        }
        return "Invalid day!";
    }
}
