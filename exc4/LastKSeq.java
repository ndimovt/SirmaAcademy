package io.github.ndimovt.exc4;

import java.util.Scanner;

public class LastKSeq {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = inn.nextInt();
        int k = inn.nextInt();
        for(int a : result(n,k)){
            System.out.print(a + " ");
        }
    }
    private static int[] result(int n, int k){
        int[] arr = new int[n];
        arr[0] = 1;
        for (int i = 1; i < n ;i++ ){
            int sum = 0;
            for(int j = Math.max(0, i - k); j < i; j++){
                sum += arr[j];
            }
            arr[i] = sum;
        }
        return arr;
    }
}
