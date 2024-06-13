package io.github.ndimovt.exc7;

import java.util.*;

public class MaximumElement {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = inn.nextInt();
        int cycleCounter = 0;
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        boolean isTrue = true;
        for (int i = 0; i < n ; i++) {
            while (isTrue) {
                String input = inn.nextLine();
                String[] command = input.split(" ");
                switch (command[0]) {
                    case "1":
                        stack.add(Integer.parseInt(command[1]));
                        cycleCounter++;
                        break;
                    case "2":
                        stack.pop();
                        cycleCounter++;
                        break;
                    case "3":
                        int biggest = 0;
                        if (!stack.isEmpty()) {
                            biggest = stack.peek();
                            for (int num : stack) {
                                if (num > biggest) {
                                    biggest = num;
                                }
                            }
                        }
                        res.add(biggest);
                        cycleCounter++;
                        break;
                    default:
                        break;
                }
                if(cycleCounter == n){
                    isTrue = false;
                }
            }
        }
        for(int a : res){
            System.out.println(a);
        }
    }
}
