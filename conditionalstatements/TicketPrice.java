package io.github.ndimovt.conditionalstatements;

import java.util.Scanner;

public class TicketPrice {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int age = inn.nextInt();

        if(age >= 0 && age <= 12 ){
            System.out.println("$5");
        } else if (age > 12 && age <= 19) {
            System.out.println("$8");
        }else {
            System.out.println("$10");
        }
    }
}
