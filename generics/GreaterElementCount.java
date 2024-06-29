package io.github.ndimovt.generics;

import java.util.List;

public class GreaterElementCount {
    public static <T extends Comparable<T>> int greaterElementsCount(List<Box<T>> list, T element){
        int count = 0;
        for(Box<T> item : list){
            if(item.getValue().compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }
}
