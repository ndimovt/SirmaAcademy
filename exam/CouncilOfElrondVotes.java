package io.github.ndimovt.exam;

import java.util.Scanner;

public class CouncilOfElrondVotes {

    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);
        int yesCount = 0;
        int noCount = 0;
        String[] votes = inn.nextLine().split(", ");
        for(String vote : votes){
            if(vote.equalsIgnoreCase("yes")){
                yesCount++;
            } else if (vote.equalsIgnoreCase("no")) {
                noCount++;
            }
        }
        if(yesCount > noCount){
            System.out.println("Yes");
        } else if (noCount > yesCount) {
            System.out.println("No");
        } else if (noCount == 0 && yesCount == 0) {
            System.out.println("Abstain");
        } else {
            System.out.println("Tie");
        }
    }
}
