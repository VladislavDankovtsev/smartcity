package ru.dankovtsev.smartcity.model;

import org.springframework.stereotype.Component;

@Component
public class ProductionAvg {
    private long count;
    private long countlist;

    public ProductionAvg() {
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getCountlist() {
        return countlist;
    }

    public void setCountlist(long countlist) {
        this.countlist = countlist;
    }
}
