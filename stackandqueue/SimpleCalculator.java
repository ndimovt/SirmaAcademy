package io.github.ndimovt.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int res = 0;
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<String> operators = new ArrayDeque<>();
        String equation = inn.nextLine();
        String[] arr = equation.split(" ");
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i].equals("+") || arr[i].equals("-")){
                operators.push(arr[i]);
            }else{
                nums.push(Integer.parseInt(arr[i]));
            }
        }
        while(!nums.isEmpty() && !operators.isEmpty()){
            int num1 = nums.pop();
            int num2 = nums.pop();
            String op = operators.pop();
            if(op.equals("+")){
                res = num1 + num2;
            }else{
                res = num1 - num2;
            }
            nums.push(res);
        }
        System.out.print(res);
    }
}
