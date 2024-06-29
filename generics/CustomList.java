package io.github.ndimovt.generics;

import java.lang.reflect.Array;

public class CustomList <T extends Comparable<T>>{
    private T[] arr;
    private int size = 0;

    public CustomList(Class<T> clazz){
        arr = (T[]) java.lang.reflect.Array.newInstance(clazz ,3);
    }

    public void add(T element){
        if(size == arr.length){
            resize(2 * arr.length);
        }
        arr[size++] = element;
    }
    public T remove(int index){
        T result = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = null;
        if(size > 0 && size > arr.length / 4){
            resize(arr.length / 2);
        }
        return result;
    }
    public boolean contains(T element){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].compareTo(element) == 0){
                return true;
            }
        }
        return false;
    }
    public void swap(int firstIndex, int secondIndex){
        T temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
    public int countGreaterThan(T element){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }
    public T getMax(){
        T element = arr[0];
        for(T array : arr){
            if(array.compareTo(element) > 0){
                element = array;
            }
        }
        return element;
    }
    public T getMin(){
        T element = arr[0];
        for(T array : arr){
            if(array.compareTo(element) < 0){
                element = array;
            }
        }
        return element;
    }
    public void printElements(){
        for(T element : arr){
            System.out.println(element);
        }
    }
    private void resize(int max){
        T[] temp = (T[]) Array.newInstance(arr.getClass().getComponentType(), max);
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

}
