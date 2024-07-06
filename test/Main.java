package io.github.ndimovt.test;

public class Main {
    public static void main(String[] args) {
        A a = new B();
        a.one();
        a.second();
        B b = (B) a;
        b.two();
        b.second();
        b.one();
    }
}
