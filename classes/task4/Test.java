package io.github.ndimovt.classes.task4;

public class Test {
    public static void main(String[] args) {
        Engine e = new Engine(126);
        Vehicle v1 = new Vehicle(e,"Volvo", "ma3",200.0);
        v1.drive(100.0);
        System.out.println(v1.getFuel());
    }
}
