package ru.dankovtsev.smartcity.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="agriculture")
public class Agriculture {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name="created_timestamp",insertable = true, updatable = false)
    private LocalDateTime time;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
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

    @Override
    public String toString() {
        return "Agriculture{" +
                "id=" + id +
                ", time=" + time +
                ", soilMoisture=" + soilMoisture +
                ", temperatureAndHumidity=" + temperatureAndHumidity +
                '}';
    }
}
