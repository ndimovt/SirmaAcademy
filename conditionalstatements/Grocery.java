package io.github.ndimovt.conditionalstatements;

import java.util.HashMap;
import java.util.Scanner;

public class Grocery {
    private static final Scanner inn = new Scanner(System.in);
    private static HashMap<String, Double> sofiaShop = new HashMap<>();
    private static HashMap<String, Double> plovdivShop = new HashMap<>();
    private static HashMap<String, Double> varnaShop = new HashMap<>();
    public static void main(String[] args) {
        String product = inn.nextLine();
        String town = inn.nextLine();
        int quantity = inn.nextInt();
        System.out.printf("%.2f",price(product, town, quantity));
    }
    public static double price(String product, String city, int quantity){
        if(city.equals("Varna")){
            priceInVarna();
            switch (product){
                case "tea", "water", "juice", "sweets", "chips":
                    return quantity * varnaShop.get(product);
                default:
                    break;
            }
        }else if(city.equals("Plovdiv")){
            priceInPlovdiv();
            switch (product){
                case "tea", "water", "juice", "sweets", "chips":
                    return quantity * plovdivShop.get(product);
                default:
                    break;
            }
        }else if(city.equals("Sofia")){
            priceInSofia();
            switch (product){
                case "tea", "water", "juice", "sweets", "chips":
                    return quantity * sofiaShop.get(product);
                default:
                    break;
            }
        }
        return 0.00;
    }
    private static void priceInSofia(){
        sofiaShop.put("tea", 0.50);
        sofiaShop.put("water", 0.80);
        sofiaShop.put("juice", 1.20);
        sofiaShop.put("sweets", 1.45);
        sofiaShop.put("chips", 1.60);
    }
    private static void priceInPlovdiv(){
        plovdivShop.put("tea", 0.40);
        plovdivShop.put("water", 0.70);
        plovdivShop.put("juice", 1.15);
        plovdivShop.put("sweets", 1.30);
        plovdivShop.put("chips", 1.50);
    }
    private static void priceInVarna(){
        varnaShop.put("tea", 0.45);
        varnaShop.put("water", 0.70);
        varnaShop.put("juice", 1.10);
        varnaShop.put("sweets", 1.35);
        varnaShop.put("chips", 1.55);
    }
}
