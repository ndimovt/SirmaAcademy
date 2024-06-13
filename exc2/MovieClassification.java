package io.github.ndimovt.exc2;

import java.util.Scanner;

public class MovieClassification {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int age = inn.nextInt();
        if(age >= 0 && age < 13){
            System.out.println("U-rated movies");
        } else if (age < 18) {
            System.out.println("U and PG-13 rated movies");
        }else {
            System.out.println("All movies");
        }
    }
}
