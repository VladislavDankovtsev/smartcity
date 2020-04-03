package ru.dankovtsev.smartcity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="production")
public class Production {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name="created_timestamp", insertable = true, updatable = false)
    private LocalDateTime time;
    @Column(name="manipulator1")
    private Integer manipulator1;
    @Column(name="manipulator2")
    private Integer manipulator2;
    @Column(name="status")
    private String status;

    public Production() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getManipulator1() {
        return manipulator1;
    }

    public void setManipulator1(Integer manipulator1) {
        this.manipulator1 = manipulator1;
    }

    public Integer getManipulator2() {
        return manipulator2;
    }

    public void setManipulator2(Integer manipulator2) {
        this.manipulator2 = manipulator2;
    }

    @Override
    public String toString() {
        return "Production{" +
                "id=" + id +
                ", time=" + time +
                ", manipulator1=" + manipulator1 +
                ", manipulator2=" + manipulator2 +
                ", status='" + status + '\'' +
                '}';
    }
}
