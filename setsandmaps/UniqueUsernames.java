package io.github.ndimovt.exc9;

import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;

public class UniqueUsernames{
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Set<String> uniqueSurnames = new LinkedHashSet<>();
        int elementCount = inn.nextInt();
        inn.nextLine();
        int count = 1;
        while(count <= elementCount){
            String surname = inn.nextLine();
            uniqueSurnames.add(surname);
            count++;
        }

        for(String s : uniqueSurnames){
            System.out.println(s);
        }
    }
}