package io.github.ndimovt.solid.dip;

public class WeatherReporter {
    private Sensor sensor;

    public WeatherReporter(Sensor sensor) {
        this.sensor = sensor;
    }
    public String report(){
        return String.format("Current water temperature %.1f",sensor.getWaterTemperature());
    }
}
