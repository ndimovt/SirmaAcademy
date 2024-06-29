package io.github.ndimovt.generics;

import java.util.Collections;
import java.util.List;

public class SwapElements{
    public static <T> void swap(List<T> list, int index1, int index2){
        Collections.swap(list, index1, index2);
    }

}
