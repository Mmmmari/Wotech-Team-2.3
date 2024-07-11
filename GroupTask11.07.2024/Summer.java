package com.datorium.Datorium.API;

public class Summer{
    public float temperature;
    public String activity;
    public boolean isHotEnoughForBeach;

    public Summer(float temperature) {
        this.temperature = temperature;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setBeachWeather(boolean isBeachWeather) {
        this.isHotEnoughForBeach = isBeachWeather;
    }
}
