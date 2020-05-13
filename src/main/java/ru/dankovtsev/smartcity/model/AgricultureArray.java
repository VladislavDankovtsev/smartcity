package ru.dankovtsev.smartcity.model;

import java.time.LocalDateTime;

public class AgricultureArray {
    private LocalDateTime time;
    private int humiditySM;
    private int humidityTaH;
    private Double temperature;

    public AgricultureArray() {
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getHumiditySM() {
        return humiditySM;
    }

    public void setHumiditySM(int humiditySM) {
        this.humiditySM = humiditySM;
    }

    public int getHumidityTaH() {
        return humidityTaH;
    }

    public void setHumidityTaH(int humidityTaH) {
        this.humidityTaH = humidityTaH;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
