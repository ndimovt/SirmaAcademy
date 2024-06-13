package io.github.ndimovt.exc5;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    private static Scanner inn = new Scanner(System.in);
    private static Random rnd = new Random();

    public static void main(String[] args) {
        String sentence = inn.nextLine();
        String[] arr = sentence.split(" ");
        randomize(arr);
        for(String n : arr){
            System.out.println(n);
        }
    }
    private static void randomize(String[] array){
        for (int i = 0; i < array.length-1 ; i++) {
            int random = rnd.nextInt(array.length);
            String temp = array[i];
            array[i] = array[random];
            array[random] = temp;
        }
    }
}
