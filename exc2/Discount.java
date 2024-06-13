package io.github.ndimovt.exc2;

import java.util.Scanner;

public class Discount {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int age = inn.nextInt();
        inn.nextLine();
        String card = inn.nextLine();

        if(age >= 0 && age < 18){
            System.out.println("10% discount");
        } else if (age >= 65) {
            System.out.println("30% discount");
        } else if (age >= 18 && card.equals("Yes")) {
            System.out.println("20% discount");
        }else {
            System.out.println("10% discount");
        }
    }
}
