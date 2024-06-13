package io.github.ndimovt.exc9;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Collections;

public class LargestThreeNumbers {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        Set<Integer> biggestThree = new TreeSet<>(Collections.reverseOrder());
        String[] numbers = inn.nextLine().split(" ");
        for(String s : numbers){
            num.add(Integer.parseInt(s));
        }
        for (int i = 0; i < 3 ; i++) {
            int max = Collections.max(num);
            biggestThree.add(max);
            num.remove(Integer.valueOf(max));
        }
        for(int a : biggestThree){
            System.out.print(a+" ");
        }
    }
}
