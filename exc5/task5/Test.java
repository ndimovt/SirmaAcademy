package io.github.ndimovt.exc5.task5;

import java.util.Scanner;

public class Test {
    private static Scanner inn = new Scanner(System.in);
    public static void main(String[] args) {
        int cap = inn.nextInt();
        Storage s = new Storage(cap);
        inn.nextLine();
        String element = inn.nextLine();
        String[] products = element.split( ",");
        for (int i = 0; i <products.length ; i++) {
            String[] arr = products[i].split(" ");
                if(arr.length == 3) {
                    Product product = new Product(arr[0], Double.parseDouble(arr[1]), Integer.parseInt(arr[2]));
                    s.addProduct(product);
                }
        }
        System.out.println(s.totalCost());
        s.getProducts();
    }
}
