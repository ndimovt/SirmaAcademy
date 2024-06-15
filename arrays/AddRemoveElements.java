package io.github.ndimovt.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class AddRemoveElements {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String element = inn.nextLine();
        String[] arr = element.split(" ");
        printArr(arr);
    }
    private static void printArr(String[] array) {
        int element = 1;
        ArrayList<Integer> result = new ArrayList<>();
        for (String word : array) {
            if (word.equals("add")) {
                result.add(element++);
            } else if (word.equals("remove")) {
                if (!result.isEmpty()) {
                    result.remove(result.size() - 1);
                }
            }
        }
        if (result.isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println(result);
        }
    }

}
