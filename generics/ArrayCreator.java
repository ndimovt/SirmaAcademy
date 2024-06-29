package io.github.ndimovt.generics;

public class ArrayCreator{
    public static <E> E[] create(int length, E item){
        E[] arr = (E[]) new Object();
        for (int i = 0; i < length; i++) {
            arr[i] = item;
        }
        return arr;
    }
    public static <E> E[] create(Class<E> classes, int length, E item){
        E[] arr = (E[]) java.lang.reflect.Array.newInstance(classes, length);
        for (int i = 0; i < length; i++) {
            arr[i] = item;
        }
        return arr;
    }
}
