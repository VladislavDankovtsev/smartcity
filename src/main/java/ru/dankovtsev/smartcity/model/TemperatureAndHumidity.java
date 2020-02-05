package ru.dankovtsev.smartcity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name="temperature_and_humidity")
public class TemperatureAndHumidity {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name="created_timestamp", insertable = true, updatable = false)
    private Timestamp time;
    @Column(name="temperature")
    private String temperature;
    @Column(name="humidity")
    private String humidity;
    @Column(name="heating_element")
    private Boolean heatingElement;
    @Column(name="fan")
    private Boolean fan;

    public TemperatureAndHumidity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public Boolean getHeatingElement() {
        return heatingElement;
    }

    public void setHeatingElement(Boolean heatingElement) {
        this.heatingElement = heatingElement;
    }

    public Boolean getFan() {
        return fan;
    }

    public void setFan(Boolean fan) {
        this.fan = fan;
    }
}
