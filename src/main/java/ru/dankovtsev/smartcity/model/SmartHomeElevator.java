package ru.dankovtsev.smartcity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="smart_home_elevator")
public class SmartHomeElevator {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name="created_timestamp", insertable = true, updatable = false)
    private LocalDateTime time;
    @Column(name="place_arrival")
    private String place_arrival;
    @Column(name="place_department")
    private String place_department;

    public SmartHomeElevator() {
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

    public String getPlace_arrival() {
        return place_arrival;
    }

    public void setPlace_arrival(String place_arrival) {
        this.place_arrival = place_arrival;
    }

    public String getPlace_department() {
        return place_department;
    }

    public void setPlace_department(String place_department) {
        this.place_department = place_department;
    }
}
