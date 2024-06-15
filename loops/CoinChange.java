package io.github.ndimovt.loops;

import java.util.Scanner;

public class CoinChange {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        double change = inn.nextDouble();
        System.out.println(coins(change));
    }
    private static int coins(double money) {
        int coinCount = 0;
        int total = (int) (money * 100);
        int lev = total / 100;
        int stotinki = (total - ((total / 100) * 100)) / 10;
        int smallStotinki = total % 10;
        if (lev == 2 || lev == 1 || lev == 0) {
            coinCount++;
            if(lev == 0){
                coinCount--;
            }
            if (stotinki == 1 || stotinki == 2 || stotinki == 5) {
                coinCount++;
            }
            else if (stotinki == 3 || stotinki == 4 || stotinki == 6 || stotinki == 7) {
                coinCount += 2;
            }
            else if (stotinki == 8 || stotinki == 9) {
                coinCount += 3;
            }
            if (smallStotinki == 1 || smallStotinki == 2 || smallStotinki == 5) {
                coinCount++;
            }
            else if (smallStotinki == 3 || smallStotinki == 4 || smallStotinki == 6 || smallStotinki == 7) {
                coinCount += 2;
            }
            else if (smallStotinki == 8 || smallStotinki == 9) {
                coinCount += 3;
            }
            return coinCount;
        }
        return 0;
    }
}
