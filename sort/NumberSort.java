package io.github.ndimovt.sort;

public final class NumberSort {
    public static int[] sort(int[] arr){
        for (int j = 0; j < arr.length * arr.length; j++) {
            for (int i = 0; i < arr.length -1; i++) {
                int firstElement = arr[i];
                int secondElement = arr[i+1];
                if(firstElement > secondElement){
                    arr[i+1] = firstElement;
                    arr[i] = secondElement;
                }
            }
        }
        return arr;
    }

    public static double[] sort(double[] arr){
        for (int j = 0; j < arr.length * arr.length; j++) {
            for (int i = 0; i < arr.length -1; i++) {
                double firstElement = arr[i];
                double secondElement = arr[i+1];
                if(firstElement > secondElement){
                    arr[i+1] = firstElement;
                    arr[i] = secondElement;
                }
            }
        }
        return arr;
    }

    public static long[] sort(long[] arr){
        for (int j = 0; j < arr.length * arr.length; j++) {
            for (int i = 0; i < arr.length -1; i++) {
                long firstElement = arr[i];
                long secondElement = arr[i+1];
                if(firstElement > secondElement){
                    arr[i+1] = firstElement;
                    arr[i] = secondElement;
                }
            }
        }
        return arr;
    }
}
