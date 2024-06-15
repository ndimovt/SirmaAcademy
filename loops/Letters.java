package io.github.ndimovt.loops;

import java.util.Scanner;

public class Letters {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String word = inn.nextLine();
        char[] letterByLetter = word.toCharArray();
        for(char symbol : letterByLetter){
            System.out.println(symbol);
        }
    }
}
