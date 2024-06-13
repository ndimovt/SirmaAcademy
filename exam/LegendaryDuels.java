package io.github.ndimovt.exam;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LegendaryDuels {
    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);
        Deque<Character> symbols = new ArrayDeque<>();
        String strikes = inn.nextLine();
        char[] arr = strikes.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '(' || arr[i] == '{'){
                symbols.push(arr[i]);
            } else if (arr[i] == ')') {
                if(symbols.isEmpty() || symbols.pop() != '('){
                    System.out.println("Not Legendary");
                    return;
                }
            } else if (arr[i] == '}') {
                if(symbols.isEmpty() || symbols.pop() != '{'){
                    System.out.println("Not Legendary");
                    return;
                }
            } else if(arr[i] == '!'){
                if(symbols.isEmpty() || symbols.peek() == '!'){
                    symbols.pop();
                }else{
                    symbols.push(arr[i]);
                }
            }
        }
        if(symbols.isEmpty()){
            System.out.println("Legendary");
        }
    }
}
