package io.github.ndimovt.exc9;

import java.util.*;

public class ParkingSystem {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String,String> numberPlates = new HashMap<>();
        List<String> history = new ArrayList<>();
        int count = inn.nextInt();
        for (int i = 0; i <= count; i++) {
            String[] arr = inn.nextLine().split(" ");
            switch (arr[0]){
                case "Register", "register":
                    if(numberPlates.containsValue(arr[2])){
                        history.add("ERROR: already registered with plate number "+arr[2]);
                    }else {
                        numberPlates.put(arr[1], arr[2]);
                        history.add(arr[1] + " registered with plate number " + arr[2]);
                    }
                    break;
                case "Unregister", "unregister":
                    if(numberPlates.containsKey(arr[1])){
                        numberPlates.remove(arr[1]);
                        history.add(arr[1]+" unregistered successfully.");
                    }else{
                        history.add("ERROR: user "+arr[1]+" not found");
                    }
                    break;
            }
        }
        for(String s : history){
            System.out.println(s);
        }
        numberPlates.forEach((k,v) -> System.out.println(k +" => "+ v));
    }
}
