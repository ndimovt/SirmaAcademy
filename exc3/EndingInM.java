package io.github.ndimovt.exc3;

import java.util.Scanner;

public class EndingInM {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = inn.nextInt();
        for (int i = 1; i <= 1000 ; i++) {
            if(i % 10 == n){
                System.out.println(i);
            }
        }
    }
}
