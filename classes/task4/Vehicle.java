package io.github.ndimovt.classes.task4;

public class Vehicle {
    private Engine engine;
    private String model;
    private String type;
    private double fuel;

    public Vehicle(Engine engine, String model, String type, double fuel) {
        this.engine = engine;
        this.model = model;
        this.type = type;
        this.fuel = fuel;
    }
    public double drive(double fuelConsumption){
        return this.fuel -= fuelConsumption;
    }
    public double getFuel() {
        return fuel;
    }
}
