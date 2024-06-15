package io.github.ndimovt.conditionalstatements;

import java.util.HashMap;
import java.util.Scanner;

public class Day {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int month = inn.nextInt();
        HashMap<Integer, Integer> months = new HashMap<>();
        months.put(1,31);months.put(2,28);months.put(3,31);months.put(4,30);months.put(5,31);months.put(6,30);months.put(7,31);months.put(8,31);
        months.put(9,30);months.put(10,31);months.put(11,30);months.put(12,31);
        System.out.println(months.get(month));
    }
}
