package io.github.ndimovt.exc2;

import java.util.HashMap;
import java.util.Scanner;

public class Market {
    private static final Scanner inn = new Scanner(System.in);
    private static HashMap<String, Double> weekend = new HashMap<>();
    private static HashMap<String, Double> week = new HashMap<>();

    public static void main(String[] args) {
        String vegetable = inn.nextLine();
        String day = inn.nextLine();
        int quantity = inn.nextInt();
        System.out.println(price(vegetable,day,quantity));
    }
    public static String price(String vegetable, String day, int quantity){
        switch (day){
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday":
                populateWeek();
                return String.format("%.2f", quantity * week.get(vegetable));
            case "Saturday", "Sunday":
                populateWeekend();
                return String.format("%.2f", quantity * weekend.get(vegetable));
            default:
                return "error";
        }
    }
    private static void populateWeekend(){
        weekend.put("tomato", 2.50);
        weekend.put("onion", 1.20);
        weekend.put("lettuce", 0.85);
        weekend.put("cucumber", 1.45);
        weekend.put("pepper", 5.50);
    }
    private static void populateWeek(){
        weekend.put("tomato", 2.80);
        weekend.put("onion", 1.30);
        weekend.put("lettuce", 0.85);
        weekend.put("cucumber", 1.75);
        weekend.put("pepper", 3.50);
    }
}
