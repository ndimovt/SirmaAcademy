package io.github.ndimovt.exc3;

import java.util.Scanner;

public class NumReversal {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = inn.nextInt();
        System.out.println(reversed(num));
    }
    public static  int reversed(int n){
        String num = Integer.toString(n);
        StringBuilder numToRev = new StringBuilder(num);
        return Integer.parseInt(numToRev.reverse().toString());
    }
}
