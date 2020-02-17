package ru.dankovtsev.smartcity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name="smart_home_climat_control")
public class SmartHomeClimatControl {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name="created_timestamp", insertable = true, updatable = false)
    private Timestamp time;
    @Column(name="temperature_in")
    private String temperatureIn;
    @Column(name="temperature_out")
    private String temperatureOut;

    public SmartHomeClimatControl() {
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

    public String getTemperatureIn() {
        return temperatureIn;
    }

    public void setTemperatureIn(String temperatureIn) {
        this.temperatureIn = temperatureIn;
    }

    public String getTemperatureOut() {
        return temperatureOut;
    }

    public void setTemperatureOut(String temperatureOut) {
        this.temperatureOut = temperatureOut;
    }
}
