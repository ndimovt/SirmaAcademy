package io.github.ndimovt.setsandmaps;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
public class WordFilter{
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Set<String> evenLengthWords = new HashSet<>();
        String[] words = inn.nextLine().split(" ");
        for(String element : words){
            if(element.length() % 2 == 0){
                evenLengthWords.add(element);
            }
        }
        for(String s : evenLengthWords){
            System.out.println(s);
        }
    }
}
