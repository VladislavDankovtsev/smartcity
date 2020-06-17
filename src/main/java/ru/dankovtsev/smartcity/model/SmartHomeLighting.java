package ru.dankovtsev.smartcity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="smart_home_lighting")
public class SmartHomeLighting {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name="created_timestamp", insertable = true, updatable = false)
    private LocalDateTime time;
    @Column(name="system_status")
    private String system_status;
    @Column(name="signal_source")
    private String signal_source;

    public SmartHomeLighting() {
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

    public String getSystem_status() {
        return system_status;
    }

    public void setSystem_status(String system_status) {
        this.system_status = system_status;
    }

    public String getSignal_source() {
        return signal_source;
    }

    public void setSignal_source(String signal_source) {
        this.signal_source = signal_source;
    }
}
