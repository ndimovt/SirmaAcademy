package io.github.ndimovt.classes.cartasks;

public class Car {
    private String brandt;
    private String model;
    private int horsepower;

    public Car(String brandt, String model) {
        this.brandt = brandt;
        this.model = model;
        this.horsepower = -1;
    }

    public Car(String brandt) {
        this.brandt = brandt;
        this.model = "unknown";
        this.horsepower = -1;
    }

    public Car(String brandt, String model, int horsepower) {
        this.brandt = brandt;
        this.model = model;
        this.horsepower = horsepower;
    }

    public String info(){
        return String.format("The car is: %s %s - %d HP", getBrandt(), getModel(), getHorsepower());
    }

    public String getBrandt() {
        return brandt;
    }

    public void setBrandt(String brandt) {
        this.brandt = brandt;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
}
