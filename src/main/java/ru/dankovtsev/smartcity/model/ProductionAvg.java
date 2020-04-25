package ru.dankovtsev.smartcity.model;

import org.springframework.stereotype.Component;

@Component
public class ProductionAvg {
    private long count;

    public ProductionAvg() {
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
