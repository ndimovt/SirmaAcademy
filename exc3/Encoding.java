package io.github.ndimovt.exc3;

import java.util.Scanner;

public class Encoding {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int number = inn.nextInt();
        chart(number);
    }
    public static void chart(int n){
        StringBuilder sb = new StringBuilder(Integer.toString(n));
        char[] rev = sb.reverse().toString().toCharArray();
        for(char c : rev){
            int charCode = (c - '0') + 33;
            print((c - '0'), (char)charCode);
        }
    }
    private static void print(int num, char symbol){
        if(symbol != 33){
            for (int i = 0; i < num; i++) {
                System.out.print(symbol);
            }
        } else {
            System.out.print("ZERO ");
        }
        System.out.println();
    }
}
