package io.github.ndimovt.exam;

import java.util.Scanner;

public class ElvishCodeCipher {

    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);
        String code = inn.nextLine();
        int n = inn.nextInt();
        char[] deciphered = new char[code.length()];
        if((code.length() >= 1 && code.length() <= 100) && (n >= 1 && n <= 25)){
            char[] arr = code.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                deciphered[i] = (char)(arr[i] - n);
            }
        }
        for(char symbol : deciphered){
            System.out.print(symbol);
        }
    }
}
