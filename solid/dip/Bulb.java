package io.github.ndimovt.solid.dip;

public class Bulb implements Switchable{
    @Override
    public void turnOn(){
        System.out.println("Switched on!");
    }
    @Override
    public void turnOff() {
        System.out.println("Switched off!");
    }
}
