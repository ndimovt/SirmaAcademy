package io.github.ndimovt.solid.dip;

public class LightSwitch{
    private Switchable device;

    public LightSwitch(Switchable device) {
        this.device = device;
    }
    public void operate(){
        device.turnOn();
    }
    public void stop(){
        device.turnOff();
    }
}
