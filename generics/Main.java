package io.github.ndimovt.generics;

import java.util.Scanner;

public class Main {
    private static Scanner inn = new Scanner(System.in);
    public static void main(String[] args) {
        CustomList<Integer> intg = new CustomList<>(Integer.class);
        intg.add(21);
        intg.add(98);
        intg.add(123);
        intg.add(258);
        System.out.println(intg.contains(258));
        intg.remove(2);
        intg.printElements();
        intg.swap(0,2);
        intg.printElements();
        System.out.println(intg.getMax());
        System.out.println(intg.countGreaterThan(90));
        System.out.println(intg.getMin());

    }


}
