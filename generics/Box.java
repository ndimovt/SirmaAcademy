package io.github.ndimovt.generics;

public class Box <T extends Comparable<T>> implements Comparable<Box<T>>{
    private T value;
    public Box(T value){
        this.value = value;
    }
    public T getValue(){
        return this.value;
    }
    @Override
    public int compareTo(Box<T> data) {
        return this.value.compareTo(data.value);
    }

    @Override
    public String toString(){
        return String.format("%s : %s", this.value.getClass().getName(), this.value);
    }


}
