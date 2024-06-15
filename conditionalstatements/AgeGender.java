package io.github.ndimovt.conditionalstatements;

import java.util.Scanner;

public class AgeGender {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int age = inn.nextInt();
        inn.nextLine();
        String gender = inn.nextLine();
        System.out.println(address(age,gender));
    }
    public static String address(int age, String symbol){
        if(symbol.equals("f")){
            if(age < 16){
                return "Miss";
            }else{
                return "Ms.";
            }
        } else if (symbol.equals("m")) {
            if(age < 16){
                return "Master";
            }else {
                return "Mr.";
            }
        }
        return null;
    }
}
