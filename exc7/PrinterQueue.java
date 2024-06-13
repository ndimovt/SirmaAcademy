package io.github.ndimovt.exc7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue {
    private static final String CANCELLED = "Canceled ";
    private static Scanner inn = new Scanner(System.in);
    private static Deque<String> printQueue = new ArrayDeque<>();

    public static void main(String[] args) {
        boolean isTrue = true;
        while(isTrue){
            String commands = inn.nextLine();
            switch (commands){
                case "cancel":
                    String canceled = CANCELLED + printQueue.getLast();
                    printQueue.offer(canceled);
                    break;
                case "print":
                    isTrue = false;
                    print(printQueue);
                    break;
                default:
                    printQueue.offer(commands);
                    break;
            }
        }
    }
    private static void print(Queue<String> q){
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}
