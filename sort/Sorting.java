package io.github.ndimovt.sort;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {4,9,1,0,7,3,5,2, -32, -69, 1235, 99, 65, -237, 9874, 25, -31};
        int[] sorted = NumberSort.sort(arr);
        for(int num : sorted){
            System.out.println(num);
        }
    }

}
