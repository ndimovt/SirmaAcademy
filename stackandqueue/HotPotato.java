package io.github.ndimovt.stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class HotPotato {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String input = inn.nextLine();
        int n = inn.nextInt();
        String[] arr = input.split(" ");
        Queue<String> q = new ArrayDeque<>();
        populateQueue(arr,q);
        while(q.size() > 1){
            for (int i = 0; i < n-1 ; i++) {
                String removed = q.remove();
                q.add(removed);
            }
            String removed = q.remove();
            System.out.println(removed + " is removed");
        }
        System.out.println(q.peek() + " is the last");
    }
    private static void populateQueue(String[] arr, Queue<String> queue){
        for(String a : arr){
            queue.offer(a);
        }
    }
}
