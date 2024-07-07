package io.github.ndimovt.solid;

import io.github.ndimovt.solid.dip.Bulb;
import io.github.ndimovt.solid.dip.LightSwitch;
import io.github.ndimovt.solid.dip.WaterTemperatureSensor;
import io.github.ndimovt.solid.dip.WeatherReporter;

public class Main {
    public static void main(String[] args) {
        /*LightSwitch lightSwitch = new LightSwitch(new Bulb());
        for (int i = 0; i <7 ; i++) {
            if(i % 2 == 0){
                lightSwitch.operate();
            }else{
                lightSwitch.stop();
            }
        }
        */
        WeatherReporter reporter = new WeatherReporter(new WaterTemperatureSensor());
        System.out.println(reporter.report());
    }
}
