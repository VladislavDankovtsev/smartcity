package ru.dankovtsev.smartcity.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="smart_home")
public class SmartHome {

    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name="created_timestamp", insertable = true, updatable = false)
    private LocalDateTime time;
    @OneToOne
    @JoinColumn(name="elevator_id")
    private SmartHomeElevator elevator;
    @OneToOne
    @JoinColumn(name="climate_control_id")
    private SmartHomeClimatControl climateControl;
    @OneToOne
    @JoinColumn(name="lighting_id")
    private SmartHomeLighting lighting;
    @OneToOne
    @JoinColumn(name="security_id")
    private SmartHomeSecurity security;

    public SmartHome() {
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

    public SmartHomeElevator getElevator() {
        return elevator;
    }

    public void setElevator(SmartHomeElevator elevator) {
        this.elevator = elevator;
    }

    public SmartHomeClimatControl getClimateControl() {
        return climateControl;
    }

    public void setClimateControl(SmartHomeClimatControl climateControl) {
        this.climateControl = climateControl;
    }

    public SmartHomeLighting getLighting() {
        return lighting;
    }

    public void setLighting(SmartHomeLighting lighting) {
        this.lighting = lighting;
    }

    public SmartHomeSecurity getSecurity() {
        return security;
    }

    public void setSecurity(SmartHomeSecurity security) {
        this.security = security;
    }
}
