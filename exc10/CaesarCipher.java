package io.github.ndimovt.exc10;

import java.util.Scanner;

public class CaesarCipher{

    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);
        String input = inn.nextLine();
        char[] arr = input.toCharArray();
        char[] cipher = new char[arr.length];
        for (int i = 0; i < arr.length ; i++) {
            cipher[i] = (char) (arr[i]+3);
            if(cipher[i] == ' '){
                cipher[i] = '#';
            }
        }
        for(char c : cipher){
            System.out.print(c);
        }
    }
}
