package ru.dankovtsev.smartcity.model;

import org.springframework.stereotype.Component;

@Component
public class SmartHomeAvg {
    private double avgTempInCC;
    private double avgTempOutCC;
    private long firstE;
    private long secondE;
    private long statusL;
    private long countPersonS;
    private long countSuccessPersonS;
    private long countlist;


    public SmartHomeAvg() {
    }

    public SmartHomeAvg(double avgTempInCC,
                        double avgTempOutCC, long firstE, long secondE,
                        long statusL, long countPersonS, long countSuccessPersonS,long countlist) {
        this.avgTempInCC = avgTempInCC;
        this.avgTempOutCC = avgTempOutCC;
        this.firstE = firstE;
        this.secondE = secondE;
        this.statusL = statusL;
        this.countPersonS = countPersonS;
        this.countSuccessPersonS = countSuccessPersonS;
        this.countlist = countlist;
    }

    public long getCountlist() {
        return countlist;
    }

    public void setCountlist(long countlist) {
        this.countlist = countlist;
    }

    public double getAvgTempInCC() {
        return avgTempInCC;
    }

    public void setAvgTempInCC(double avgTempInCC) {
        this.avgTempInCC = avgTempInCC;
    }

    public double getAvgTempOutCC() {
        return avgTempOutCC;
    }

    public void setAvgTempOutCC(double avgTempOutCC) {
        this.avgTempOutCC = avgTempOutCC;
    }

    public long getFirstE() {
        return firstE;
    }

    public void setFirstE(long firstE) {
        this.firstE = firstE;
    }

    public long getSecondE() {
        return secondE;
    }

    public void setSecondE(long secondE) {
        this.secondE = secondE;
    }

    public long getStatusL() {
        return statusL;
    }

    public void setStatusL(long statusL) {
        this.statusL = statusL;
    }

    public long getCountPersonS() {
        return countPersonS;
    }

    public void setCountPersonS(long countPersonS) {
        this.countPersonS = countPersonS;
    }

    public long getCountSuccessPersonS() {
        return countSuccessPersonS;
    }

    public void setCountSuccessPersonS(long countSuccessPersonS) {
        this.countSuccessPersonS = countSuccessPersonS;
    }
}
