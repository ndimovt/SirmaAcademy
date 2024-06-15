package io.github.ndimovt.exc9;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;
import java.util.LinkedHashMap;

public class CompanyUsers {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, ArrayList<String>> info = new LinkedHashMap<>();
        boolean isTrue = true;
        while(isTrue){
            String[] record = inn.nextLine().split(" -> ");
            switch(record[0]){
                case "End":
                    isTrue = false;
                    break;
                default:
                    info.computeIfAbsent(record[0], v -> new ArrayList<>()).add(record[1]);
                    break;
            }
        }
        Set<String> keys = info.keySet();
        for(String key: keys){
            System.out.println(key);
            ArrayList<String> values = info.get(key);
            for(String v : values){
                System.out.println("--"+v);
            }
        }
    }
}
