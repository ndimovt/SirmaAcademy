package io.github.ndimovt.exc10;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitsLettersEtc {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String word = inn.nextLine();
        Pattern digit = Pattern.compile("[\\d]+");
        Pattern symbol = Pattern.compile("[\\^\\%\\&\\|\\*\\@\\!\\#\\,\\+\\-\\=\\!]+");
        Pattern letters = Pattern.compile("[A-Za-z]+");
        Matcher mDigit = digit.matcher(word);
        Matcher mSymbol = symbol.matcher(word);
        Matcher mLetter = letters.matcher(word);
        while(mDigit.find()){
            System.out.print(mDigit.group());
        }
        System.out.println();

        while(mLetter.find()){
            System.out.print(mLetter.group());
        }
        System.out.println();

        while(mSymbol.find()){
            System.out.print(mSymbol.group());
        }
        System.out.println();
    }
}
