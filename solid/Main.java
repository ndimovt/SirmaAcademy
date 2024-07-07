package io.github.ndimovt.solid;

import io.github.ndimovt.solid.dip.Bulb;
import io.github.ndimovt.solid.dip.LightSwitch;

public class Main {
    public static void main(String[] args) {
        LightSwitch lightSwitch = new LightSwitch(new Bulb());
        for (int i = 0; i <7 ; i++) {
            if(i % 2 == 0){
                lightSwitch.operate();
            }
            lightSwitch.stop();
        }
    }
}
