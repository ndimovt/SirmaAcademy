package io.github.ndimovt.generics;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CustomListMenu {
    private static Scanner inn = new Scanner(System.in);
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        CustomList<String> list = new CustomList<>(String.class);
        boolean isWorking = true;
        System.out.println("Choose between following commands:");
        System.out.println("Add {element}, Remove {index}, Contains {element}, Swap {index1} {index2}, Greater {element}, Max, Min, Print, end");
        while(isWorking){
            String choice = inn.nextLine();
            String[] arr = choice.split(" ");
            switch (arr[0]){
                case "Add":
                    list.add(arr[1]);
                    break;
                case "Remove":
                    stack.push(list.remove(Integer.parseInt(arr[1])));
                    break;
                case "Contains":
                    stack.push(String.valueOf(list.contains(arr[1])));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                    break;
                case "Greater":
                    int count = list.countGreaterThan(arr[1]);
                    stack.push(String.valueOf(count));
                    break;
                case "Max":
                    stack.push(list.getMax());
                    break;
                case "Min":
                    stack.push(list.getMin());
                    break;
                case "Print":
                    list.printElements();
                    break;
                case "end":
                    while(!stack.isEmpty()){
                        System.out.println(stack.pollFirst());
                    }
                    isWorking = false;
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }
}
