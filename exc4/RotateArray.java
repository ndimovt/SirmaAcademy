package io.github.ndimovt.exc4;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String element = inn.nextLine();
        String[] arr = element.split(" ");
        int numOfRotations = inn.nextInt();
        System.out.println(elements(numOfRotations, arr));
    }
    private static String elements(int n, String[] toRotate){
        int length = toRotate.length;
        n %= length;
        String[] rotatedArray = new String[length];
        for (int i = 0; i < length; i++) {
            rotatedArray[(i + n) % length] = toRotate[i];
        }
        return Arrays.toString(rotatedArray);
    }
}
