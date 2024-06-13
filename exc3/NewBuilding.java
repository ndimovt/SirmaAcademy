package io.github.ndimovt.exc3;

import java.util.Scanner;

public class NewBuilding {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int floors = inn.nextInt();
        int rooms = inn.nextInt();
        printBuilding(floors, rooms);
    }
    private static void printBuilding(int n, int k){
        for (int i = n; i > 0 ; i--) {
            for (int j = 0; j < k ; j++) {
                if(i % 2 == 0 && i != n){
                System.out.print("O");
                }else if(i == n){
                    System.out.print("L");
                }else{
                    System.out.print("A");
                }
                    System.out.print(i+""+j+" ");
            }
            System.out.println();
        }
    }
}
