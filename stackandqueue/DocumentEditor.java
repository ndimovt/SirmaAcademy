package io.github.ndimovt.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentEditor {
    private static Deque<String> commands = new ArrayDeque<>();
    private static Deque<String> edited = new ArrayDeque<>();
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String result = null;
        DocumentEditor de = new DocumentEditor();
        boolean isTrue = true;
        while(isTrue){
            String word = inn.nextLine();
            switch (word){
                case "End":
                    isTrue = false;
                    de.print(edited);
                    break;
                case "Undo()":
                    result = de.undo(commands);
                    edited.add(de.peekMainStack(commands));
                    break;
                case "Redo()":
                    commands.add(result);
                    edited.add(de.peekMainStack(commands));
                    break;
                default:
                    String splitted = "\"([^\\\"]*)\"";
                    Pattern p = Pattern.compile(splitted);
                    Matcher m = p.matcher(word);
                    if(m.find()) {
                        commands.add(m.group(1));
                        edited.add(de.peekMainStack(commands));
                    }
                    break;
            }
        }
    }
    private String peekMainStack(Deque<String> stack){
        StringBuilder sb = new StringBuilder();
        for(String item : stack){
            sb.append(item);
        }
        return sb.toString();
    }
    private String undo(Deque<String> stack) {
        return stack.pollLast();
    }
    private void print(Deque<String> finalResult){
        while(!finalResult.isEmpty()){
            System.out.println(finalResult.pop());
        }
    }
}
