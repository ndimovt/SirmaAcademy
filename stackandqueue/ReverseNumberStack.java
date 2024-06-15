package io.github.ndimovt.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumberStack {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Deque<Integer> reverse = new ArrayDeque<>();
        String num = inn.nextLine();
        String[] nums = num.split(" ");
        int[] array = Arrays.stream(nums).mapToInt(Integer::parseInt).toArray();
        for(int a : array){
            reverse.push(a);
        }
        while(!reverse.isEmpty()){
            System.out.print(reverse.pop()+" ");
        }
    }
}
