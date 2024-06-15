package io.github.ndimovt.exc9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Long> phones = new HashMap<>();
        boolean isTrue = true;
        while (isTrue) {
            String phoneName = inn.nextLine();
            switch (phoneName) {
                case "stop", "Stop", "STOP":
                    isTrue = false;
                    printContacts(phones);
                default:
                    String[] arr = phoneName.split("-");
                    if(arr.length == 2) {
                        phones.put(arr[0], Long.parseLong(arr[1]));
                    }else{
                        phones.put(arr[0], null);
                    }
                    break;
            }
        }
    }
    private static void printContacts(Map<String, Long> map) {
        map.forEach((k, v) -> {
            if (v == null) {
                System.out.printf("Contact %s does not exists!\n", k);
            } else {
                System.out.printf("%s -> %d\n", k, v);
            }
        });
    }
}
