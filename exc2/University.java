package io.github.ndimovt.exc2;

import java.util.Scanner;

public class University {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int score = inn.nextInt();
        int activities = inn.nextInt();
        if(score >= 90){
            System.out.println("Admitted");
        } else if (score >= 80 && activities >= 2) {
            System.out.println("Admitted");
        }else {
            System.out.println("Not admitted");
        }
    }
}
