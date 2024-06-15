package io.github.ndimovt.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinaryConv {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int number = inn.nextInt();
        binaryNum(number);
    }
    private static long binaryNum(int n){
        Deque<Integer> nums = new ArrayDeque<>();
        if(n != 0){
            while(n != 0){
                nums.push(n % 2);
                n /= 2;
            }
            printNum(nums);
        }
        return 0;
    }
    private static void printNum(Deque<Integer> binary){
        while(!binary.isEmpty()){
            System.out.print(binary.pop());
        }
        System.out.println();
    }
}
