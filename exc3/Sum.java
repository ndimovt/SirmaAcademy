package io.github.ndimovt.exc3;

import java.util.Scanner;

public class Sum {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = inn.nextInt();
        System.out.println(sumOfEven(num));
    }
    public static int sumOfEven(int n){
        int total = 0;
        for (int i = 1; i <=n ; i++) {
            total += 2*i;
        }
        return total;
    }
    
}
