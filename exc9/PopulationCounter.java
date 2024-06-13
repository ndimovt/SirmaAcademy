package io.github.ndimovt.exc9;

import java.util.*;

public class PopulationCounter {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> countries = new LinkedHashMap<>();
        while (true) {
            String line = inn.nextLine();
            if (line.equals("report")) {
                break;
            }
            String[] parts = line.split("\\|");
            String city = parts[0];
            String country = parts[1];
            int population = Integer.parseInt(parts[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).put(city, population);
        }

        for(Map.Entry<String, Map<String, Integer>> entry : countries.entrySet()){
            int totalPopulation = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
            System.out.printf("%s (total population: %d)\n", entry.getKey(), totalPopulation);
            Map<String,Integer> countriesInfo = entry.getValue();
            for(Map.Entry<String, Integer> element : countriesInfo.entrySet()){
                System.out.printf("=>%s: %d\n", element.getKey(), element.getValue());
            }
        }
    }
}
