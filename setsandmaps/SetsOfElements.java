package io.github.ndimovt.setsandmaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        Set<Integer> nonRepeatingElements = new HashSet<>();
        String[] size = inn.nextLine().split(" ");
        int firstSize = Integer.parseInt(size[0]);
        int secondSize = Integer.parseInt(size[1]);
        for (int i = 0; i <firstSize ; i++) {
            int n = inn.nextInt();
            first.add(n);
        }
        for (int i = 0; i < secondSize ; i++) {
            int n = inn.nextInt();
            second.add(n);
        }
        first.forEach((k) -> {
            if(!second.contains(k)){
                nonRepeatingElements.add(k);
            }
        });
        second.forEach((k) -> {
            if(!first.contains(k)){
                nonRepeatingElements.add(k);
            }
        });
        nonRepeatingElements.forEach(System.out::print);
    }
}
