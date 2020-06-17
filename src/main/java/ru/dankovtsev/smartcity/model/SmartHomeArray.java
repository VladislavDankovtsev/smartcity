package ru.dankovtsev.smartcity.model;


import java.time.LocalDateTime;

public class SmartHomeArray {
    private LocalDateTime time;
    private Double temperatureIn;
    private Double temperatureOut;

    public SmartHomeArray() {
    }

    public SmartHomeArray(LocalDateTime time, Double temperatureIn, Double temperatureOut) {
        this.time = time;
        this.temperatureIn = temperatureIn;
        this.temperatureOut = temperatureOut;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Double getTemperatureIn() {
        return temperatureIn;
    }

    public void setTemperatureIn(Double temperatureIn) {
        this.temperatureIn = temperatureIn;
    }

    public Double getTemperatureOut() {
        return temperatureOut;
    }

    public void setTemperatureOut(Double temperatureOut) {
        this.temperatureOut = temperatureOut;
    }
}
