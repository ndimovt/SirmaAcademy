package io.github.ndimovt.exc9;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StudentAcademy {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, ArrayList<Double>> students = new TreeMap<>();
        int records = inn.nextInt();
        inn.nextLine();
        int count = 1;
        while(count <= records){
            String student = inn.nextLine();
            double grade = inn.nextDouble();
            inn.nextLine();
            students.computeIfAbsent(student, k -> new ArrayList<>()).add(grade);
            count++;
        }
        students.forEach((k,v) -> {
            double average = 0;
            for(double num : v){
                average += num;
            }
            average /= v.size();
            System.out.printf("%s -> %.2f \n",k,average);
        });
    }
}
