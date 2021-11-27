package com.company;

public class TrigerSensor {
    private boolean type_of_trigering;
    private String time;

    public TrigerSensor(){
        this.type_of_trigering = true;
        this.time = "";
    }

    public TrigerSensor(boolean type_of_trigering, String time) {
        this.type_of_trigering = type_of_trigering;
        this.time = time;
    }

    public boolean isType_of_trigering() {
        return type_of_trigering;
    }

    public void setType_of_trigering(boolean type_of_trigering) {
        this.type_of_trigering = type_of_trigering;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
