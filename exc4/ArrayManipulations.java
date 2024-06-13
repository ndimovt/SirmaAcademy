package io.github.ndimovt.exc4;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulations {
    private static Scanner inn = new Scanner(System.in);
    private static int[] arr;
    public static void main(String[] args) {
        String numbers = inn.nextLine();
        String[] numArray = numbers.split(" ");
        String commands = inn.nextLine();
        String[] comandsArr = commands.split(",");
        arr = Arrays.stream(numArray).mapToInt(Integer::parseInt).toArray();
        menu(comandsArr);
        for(int a: arr){
            System.out.print(a + " ");
        }
    }
    private static void menu(String[] command){
        for(String word : command){
            String[] separate = word.split(" ");
            if (separate.length == 2 && separate[0].equals("Add")) {
                add(Integer.parseInt(separate[1]));
            } else if (separate.length == 2 && separate[0].equals("Remove")) {
                remove(Integer.parseInt(separate[1]));
            } else if (separate.length == 2 && separate[0].equals("RemoveAt")) {
                removeAt(Integer.parseInt(separate[1]));
            } else if (separate.length == 3 && separate[0].equals("InsertAt")) {
                insertAt(Integer.parseInt(separate[1]), Integer.parseInt(separate[2]));
            }
        }
    }
    private static void add(int n) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = n;
        arr = newArr;
    }
    private static void remove(int n) {
        int[] removedElement = Arrays.copyOf(arr, arr.length - 1);
        for (int i = 0, j = 0; i < arr.length ; i++) {
            if(arr[i] != n){
                removedElement[j] = arr[i];
                j++;
            }
        }
        arr = removedElement;
    }
    private static void removeAt(int index) {
        int[] updated = Arrays.copyOf(arr, arr.length - 1);
        for (int i = 0, j = 0; i < arr.length ; i++) {
            if(i != index){
                updated[j] = arr[i];
                j++;
            }
        }
        arr = updated;
    }
    private static void insertAt(int index, int element){
        int[] withNewElement = Arrays.copyOf(arr, arr.length + 1);
        if(index > arr.length){
            throw new ArrayIndexOutOfBoundsException("Invalid index!");
        }
        for (int i = 0, j = 0; i < arr.length + 1 ; i++) {
            if (i == index) {
                withNewElement[i] = element;
            }else{
                withNewElement[i] = arr[j++];
            }

        }
        arr = withNewElement;
    }

}
