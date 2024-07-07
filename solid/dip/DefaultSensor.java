package io.github.ndimovt.solid.dip;

public abstract class DefaultSensor implements Sensor{
    @Override
    public double getAmbientTemperature(){
        return 10.0;
    }
    @Override
    public double getWaterTemperature() {
        return 10.0;
    }
}
