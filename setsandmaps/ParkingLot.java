package io.github.ndimovt.setsandmaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        Set<String> carNumbers = new HashSet<>();
        while(true){
            String[] arr = inn.nextLine().split(", ");
            if(arr[0].equalsIgnoreCase("end")){
                break;
            } else if (arr[0].equalsIgnoreCase("in")) {
                carNumbers.add(arr[1]);
            } else if (arr[0].equalsIgnoreCase("out")) {
                carNumbers.remove(arr[1]);
            }
        }
        carsInLot(carNumbers);
    }
    private static void carsInLot(Set<String> s){
        if(s.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        s.forEach(System.out::println);
    }
}
