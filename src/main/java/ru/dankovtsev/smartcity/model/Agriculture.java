package ru.dankovtsev.smartcity.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name="agriculture")
public class Agriculture {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name="created_timestamp",insertable = true, updatable = false)
    private Timestamp time;
    @OneToOne
    @JoinColumn(name="soil_moisture")
    private SoilMoisture soilMoisture;
    @OneToOne
    @JoinColumn(name="temperature_and_humidity")
    private TemperatureAndHumidity temperatureAndHumidity;

    public Agriculture() {
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

    public TemperatureAndHumidity getTemperatureAndHumidity() {
        return temperatureAndHumidity;
    }

    public void setTemperatureAndHumidity(TemperatureAndHumidity temperatureAndHumidity) {
        this.temperatureAndHumidity = temperatureAndHumidity;
    }

    public SoilMoisture getSoilMoisture() {
        return soilMoisture;
    }

    public void setSoilMoisture(SoilMoisture soilMoisture) {
        this.soilMoisture = soilMoisture;
    }
}
