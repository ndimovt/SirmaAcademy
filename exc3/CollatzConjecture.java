package io.github.ndimovt.exc3;

import java.util.Scanner;

public class CollatzConjecture {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = inn.nextInt();
        check(num);
    }
    public static void check(int n){
        while(n != 1){
            System.out.print(n + " ");
            if(n % 2 == 0){
                n = n / 2;
            }else{
                n = n * 3 + 1;
            }
        }
        System.out.print(n);
    }
}
