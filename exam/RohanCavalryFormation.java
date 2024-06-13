package io.github.ndimovt.exam;

import java.util.*;

public class RohanCavalryFormation {
    public static void main(String[] args) {
        boolean isTrue = true;
        Scanner inn = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        Deque<String> result = new ArrayDeque<>();
        String[] formation = inn.nextLine().split(", ");
        populateList(formation, numbers);

        while(isTrue){
            String[] command = inn.nextLine().split(" ");
            switch (command[0]){
                case "end":
                    isTrue = false;
                    break;
                case "center":
                    StringBuilder center = new StringBuilder();
                    if(numbers.size() % 2 == 0){
                        int midRiderOne = numbers.get((numbers.size() / 2) - 1);
                        int midRiderTwo = numbers.get(numbers.size() / 2);
                        center.append(midRiderOne).append(" ").append(midRiderTwo);
                        result.add(center.toString());
                        center.delete(0, center.length());
                        break;
                    }else{
                        int centerIndex = numbers.get((numbers.size() / 2));
                        center.append(centerIndex);
                        result.add(center.toString());
                        center.delete(0, center.length());
                        break;
                    }
                case "insert":
                    int num = Integer.parseInt(command[1]);
                    int id = Integer.parseInt(command[2]);
                    if(numbers.contains(id)) {
                        numbers.add(id, num);
                        updateList(numbers, result);
                    }
                    break;
                case "destroy":
                    int destroyed = Integer.parseInt(command[1]);
                    if(numbers.contains(destroyed)) {
                        numbers.remove(destroyed);
                        updateList(numbers, result);
                    }
                    break;
                case "add":
                    int element = Integer.parseInt(command[1]);
                    numbers.add(element);
                    updateList(numbers, result);
                    break;
                case "swap":
                    int firstElement = Integer.parseInt(command[1]);
                    int secondElement = Integer.parseInt(command[2]);
                    if(firstElement >= 0 && firstElement < numbers.size() && secondElement >= 0 && secondElement < numbers.size() && firstElement != secondElement) {
                        Collections.swap(numbers, firstElement, secondElement);
                        updateList(numbers, result);
                    }
                    break;
                default:
                    System.out.println("No such command!");
                    break;
            }
        }
        formationHistory(result);
    }
    private static void updateList(List<Integer> list, Deque<String> stack){
        StringBuilder sb = new StringBuilder();
        for(int a : list){
            sb.append(a).append(" ");
        }
        stack.add(sb.toString());
    }
    private static void populateList(String[] arr, List<Integer> list){
        for(String s : arr){
            list.add(Integer.parseInt(s));
        }
    }
    private static void formationHistory(Deque<String> stack){
        while(!stack.isEmpty()){
            System.out.println(stack.pollFirst());
        }
    }
}
