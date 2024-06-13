package io.github.ndimovt.exc9;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, ArrayList<Double>> students = new TreeMap<>();
        int studentNumber = inn.nextInt();
        inn.nextLine();
        int count = 1;
        while(count <= studentNumber){
            String[] student = inn.nextLine().split(" ");
            double grade = Double.parseDouble(student[1]);
            students.computeIfAbsent(student[0], k -> new ArrayList<>()).add(grade);
            count++;
        }
        students.forEach((k,v) -> {
            double total = 0;
            for(double num : v){
                total += num;
            }
            total /= v.size();
            System.out.println(k + " -> "+ v + " (avg: "+total+")");
        });
    }
}
