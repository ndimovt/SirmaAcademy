package io.github.ndimovt.setsandmaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PartyList {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Set<String> vip = new HashSet<>();
        Set<String> regular = new HashSet<>();
        boolean isPartyOn = true;
        while (isPartyOn) {
            String guest = inn.nextLine();
            switch (guest) {
                case "party":
                    while (true) {
                        String coming = inn.nextLine();
                        if (coming.equalsIgnoreCase("end")) {
                            isPartyOn = false;
                            break;
                        } else {
                            remove(vip, regular, coming);
                        }
                    }
                    break;
                case "end":
                    isPartyOn = false;
                    break;
                default:
                    add(vip, regular, guest);
                    break;
            }
        }
        System.out.println(total(vip, regular));
        print(vip, regular);
    }
    private static void remove(Set<String> vip, Set<String> reg, String word){
        if(Character.isDigit(word.charAt(0))){
            vip.remove(word);
        }else{
            reg.remove(word);
        }
    }
    private static void add(Set<String> vip, Set<String> reg, String guest) {
        if (Character.isDigit(guest.charAt(0))) {
            vip.add(guest);
        } else {
            reg.add(guest);
        }
    }
    private static int total(Set<String> vip, Set<String> reg){
        return vip.size() + reg.size();
    }
    private static void print(Set<String> vip, Set<String> reg){
        vip.forEach(System.out::println);
        reg.forEach(System.out::println);
    }
}
