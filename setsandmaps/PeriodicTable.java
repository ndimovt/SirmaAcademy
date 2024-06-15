package io.github.ndimovt.setsandmaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable{
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Set<String> mendeleevTable = new TreeSet<>();
        int elementCount = inn.nextInt();
        inn.nextLine();
        int count = 1;
        while(count <= elementCount){
            String[] element = inn.nextLine().split(" ");
            for(String word : element){
                mendeleevTable.add(word);
            }
            count++;
        }

        for(String s : mendeleevTable){
            System.out.print(s + " ");
        }
    }
}