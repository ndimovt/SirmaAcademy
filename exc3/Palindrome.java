package io.github.ndimovt.exc3;

import java.util.Scanner;

public class Palindrome {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String word = inn.nextLine();
        System.out.println(palindromeCheck(word));
    }
    public static boolean palindromeCheck(String toCheck){
        StringBuilder reversed = new StringBuilder(toCheck);
        reversed.reverse();
        if(reversed.toString().equalsIgnoreCase(toCheck)){
            return true;
        }
        return false;
    }
}
