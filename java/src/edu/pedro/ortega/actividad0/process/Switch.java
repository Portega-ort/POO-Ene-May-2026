package edu.pedro.ortega.actividad0.process;

public class Switch {

    private boolean isOn;

    public void prenderSwitch(){
        isOn = true;
    }

    public void apagarSwitch(){
        isOn = false;

    }

    public boolean isOn(){
        return this.isOn;
    }

}