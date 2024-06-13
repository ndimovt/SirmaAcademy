package io.github.ndimovt.exc7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Deque<Character> result = new ArrayDeque<>();
        String parentheses = inn.nextLine();
        System.out.print(isTrue(parentheses, result));
    }
    private static boolean isTrue(String word, Deque<Character> res){
        int count = 0;
        char[] arr = word.toCharArray();
        for(char a : arr){
            res.push(a);
        }
        while(!res.isEmpty()){
            char symbol = res.pop();
            if(symbol == '{' || symbol == '[' || symbol == '('){
                count++;
            }else{
                count--;
            }
        }
        if(count == 0){
            return true;
        }
        return false;
    }
}
