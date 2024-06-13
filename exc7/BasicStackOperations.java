package io.github.ndimovt.exc7;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations {
    private static Scanner inn = new Scanner(System.in);
    private static Deque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        String command = inn.nextLine();
        String [] splitted = command.split(" ");
        int[] arr = Arrays.stream(splitted).mapToInt(Integer::parseInt).toArray();
        result(arr);
    }
    private static void result(int[] array){
        int count = 1;
        int elementsToPush = 1;
        int elementsToPop = 1;
        int elementToCheck = 1;
        for (int i = 0; i < array.length ; i++) {
            elementsToPush = array[0];
            elementsToPop = array[1];
            elementToCheck = array[2];
        }
        while(count <= elementsToPush){
            int n = inn.nextInt();
            queue.offer(n);
            count++;
        }
        for (int i = 0; i < elementsToPop ; i++) {
            queue.poll();
        }
        if (!queue.isEmpty()) {
            int min = Integer.MAX_VALUE;
            for (int num : queue) {
                if (num < min) {
                    min = num;
                }
            }
            if (queue.contains(elementToCheck)) {
                System.out.println("true");
            } else {
                System.out.println(min);
            }
        } else {
            System.out.println(0);
        }
    }
}
