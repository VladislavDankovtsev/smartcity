package ru.dankovtsev.smartcity.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class PersonList {
    private UUID id;
    private String name;
    private Long count;
    private LocalDateTime timeLast;

    public PersonList() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public LocalDateTime getTimeLast() {
        return timeLast;
    }

    public void setTimeLast(LocalDateTime timeLast) {
        this.timeLast = timeLast;
    }
}
