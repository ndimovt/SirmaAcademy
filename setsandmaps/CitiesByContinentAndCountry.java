package io.github.ndimovt.setsandmaps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, LinkedHashMap<String, ArrayList<String>>> countries = new LinkedHashMap<>();
        int count = inn.nextInt();
        inn.nextLine();
        for (int i = 0; i < count; i++) {
            String[] info = inn.nextLine().split(" ");
            String continent = info[0];
            String country = info[1];
            String city = info[2];
            countries.computeIfAbsent(continent, k -> new LinkedHashMap<>());
            countries.get(continent).computeIfAbsent(country, k -> new ArrayList<>());
            countries.get(continent).get(country).add(city);
        }

        for(Map.Entry<String, LinkedHashMap<String, ArrayList<String>>> entry : countries.entrySet()){
            System.out.println(entry.getKey()+":");
            LinkedHashMap<String, ArrayList<String>> countriesInfo = entry.getValue();
            for(Map.Entry<String, ArrayList<String>> element : countriesInfo.entrySet()){
                System.out.printf(" %s -> ", element.getKey());
                System.out.println(String.join(", ", element.getValue()));
            }
        }
    }
}
