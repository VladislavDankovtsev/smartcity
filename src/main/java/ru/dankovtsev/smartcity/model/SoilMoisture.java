package ru.dankovtsev.smartcity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="agriculture_soil_moisture")
public class SoilMoisture {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name="created_timestamp", insertable = true, updatable = false)
    private LocalDateTime time;
    @Column(name="humidity")
    private String humidity;
    @Column(name="water")
    private Boolean water;

    public SoilMoisture() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public Boolean getWater() {
        return water;
    }

    public void setWater(Boolean water) {
        this.water = water;
    }

}
