package io.github.ndimovt.exam;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class OrthancArchivesSearch {

    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);
        Deque<Integer> occurrences = new ArrayDeque<>();
        String[] records = inn.nextLine().split(", ");
        String element = inn.nextLine();
        for (int i = 0; i < records.length; i++) {
            if (records[i].equals(element)) {
                occurrences.add(i);
            }
        }
        if (occurrences.isEmpty()) {
            System.out.println("Record not found");
        } else {
            System.out.printf("First Occurrence: %d\n", occurrences.getFirst());
            System.out.printf("Last Occurrence: %d\n", occurrences.getLast());
        }
    }
}
