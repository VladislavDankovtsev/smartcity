package ru.dankovtsev.smartcity.model;

import org.springframework.stereotype.Component;

@Component
public class AgricultureAvg {
    private double avgHumiditySM;
    private double avgHumidityTH;
    private double avgTemperatureTH;
    private int countWaterSM;
    private int countFanTH;
    private int countHeatingElementTH;

    public AgricultureAvg() {
    }

    public double getAvgHumiditySM() {
        return avgHumiditySM;
    }

    public void setAvgHumiditySM(double avgHumiditySM) {
        this.avgHumiditySM = avgHumiditySM;
    }

    public double getAvgHumidityTH() {
        return avgHumidityTH;
    }

    public void setAvgHumidityTH(double avgHumidityTH) {
        this.avgHumidityTH = avgHumidityTH;
    }

    public double getAvgTemperatureTH() {
        return avgTemperatureTH;
    }

    public void setAvgTemperatureTH(double avgTemperatureTH) {
        this.avgTemperatureTH = avgTemperatureTH;
    }

    public int getCountWaterSM() {
        return countWaterSM;
    }

    public void setCountWaterSM(int countWaterSM) {
        this.countWaterSM = countWaterSM;
    }

    public int getCountFanTH() {
        return countFanTH;
    }

    public void setCountFanTH(int countFanTH) {
        this.countFanTH = countFanTH;
    }

    public int getCountHeatingElementTH() {
        return countHeatingElementTH;
    }

    public void setCountHeatingElementTH(int countHeatingElementTH) {
        this.countHeatingElementTH = countHeatingElementTH;
    }
}
