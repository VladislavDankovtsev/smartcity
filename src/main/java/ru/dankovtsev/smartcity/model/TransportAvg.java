package ru.dankovtsev.smartcity.model;

import org.springframework.stereotype.Component;

@Component
public class TransportAvg {
    private int g1;
    private int g2;
    private int g3;
    private int g4;
    private int g5;
    private int g6;
    private int g7;
    private int g8;
    private int g9;
    private int g10;
    private int gOther;
    private long countlist;

    public TransportAvg() {
    }

    public TransportAvg(int g1, int g2, int g3, int g4, int g5, int g6, int g7, int g8, int g9, int g10, int gOther, long countlist) {
        this.g1 = g1;
        this.g2 = g2;
        this.g3 = g3;
        this.g4 = g4;
        this.g5 = g5;
        this.g6 = g6;
        this.g7 = g7;
        this.g8 = g8;
        this.g9 = g9;
        this.g10 = g10;
        this.gOther = gOther;
        this.countlist = countlist;
    }

    public long getCountlist() {
        return countlist;
    }

    public void setCountlist(long countlist) {
        this.countlist = countlist;
    }

    public int getgOther() {
        return gOther;
    }

    public void setgOther(int gOther) {
        this.gOther = gOther;
    }

    public int getG1() {
        return g1;
    }

    public void setG1(int g1) {
        this.g1 = g1;
    }

    public int getG2() {
        return g2;
    }

    public void setG2(int g2) {
        this.g2 = g2;
    }

    public int getG3() {
        return g3;
    }

    public void setG3(int g3) {
        this.g3 = g3;
    }

    public int getG4() {
        return g4;
    }

    public void setG4(int g4) {
        this.g4 = g4;
    }

    public int getG5() {
        return g5;
    }

    public void setG5(int g5) {
        this.g5 = g5;
    }

    public int getG6() {
        return g6;
    }

    public void setG6(int g6) {
        this.g6 = g6;
    }

    public int getG7() {
        return g7;
    }

    public void setG7(int g7) {
        this.g7 = g7;
    }

    public int getG8() {
        return g8;
    }

    public void setG8(int g8) {
        this.g8 = g8;
    }

    public int getG9() {
        return g9;
    }

    public void setG9(int g9) {
        this.g9 = g9;
    }

    public int getG10() {
        return g10;
    }

    public void setG10(int g10) {
        this.g10 = g10;
    }
}
