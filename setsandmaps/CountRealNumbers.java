package io.github.ndimovt.setsandmaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;
public class CountRealNumbers {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Double, Integer> result = new LinkedHashMap<>();
        List<Double> temp = new ArrayList<>();
        String[] numbers = inn.nextLine().split(" ");
        for(String a : numbers){
            temp.add(Double.parseDouble(a));
        }
        for(double d : temp){
            result.put(d, result.getOrDefault(d, 0) + 1);
        }
        result.forEach((k,v) -> System.out.printf("%.1f -> %d\n",k,v));
    }
}
