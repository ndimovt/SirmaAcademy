package io.github.ndimovt.test;

public class B extends A{
    public void two(){
        System.out.println("In class B specific method");
    }

    @Override
    public void one(){
        System.out.println("In class B");
    }
}
