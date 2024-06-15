package io.github.ndimovt.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Browser {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Deque<String> commands = new ArrayDeque<>();
        boolean isTrue = true;
        while(isTrue){
            String url = inn.nextLine();
            switch (url){
                case "Back":
                    commands.pop();
                    if(commands.peek() != null) {
                        System.out.println(commands.peek());
                    }else{
                        System.out.println("No more Url's");
                    }
                    break;
                case "Home":
                    isTrue = false;
                    break;
                default:
                    System.out.println(url);
                    commands.push(url);
                    break;
            }
        }
    }
}
