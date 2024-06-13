package io.github.ndimovt.exc3;

import java.util.Scanner;

public class SpecialNumbers {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = inn.nextInt();
        number(num);
    }
    private static void number (int n){
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                for (int k = 1; k <=n ; k++) {
                    for (int l = 1; l <=n ; l++) {
                        if(n % i ==0 && n%j==0 && n%k==0 && n%i==0){
                            System.out.print(""+i+j+k+l+"\n");
                        }
                    }
                }
            }
        }
    }
}
