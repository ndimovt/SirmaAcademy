package io.github.ndimovt.generics;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar <T>{
    private final Deque<T> deck = new ArrayDeque<>();
    public void add(T element){
        this.deck.push(element);
    }
    public T remove(){
        return this.deck.pop();
    }
}
