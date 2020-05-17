package ru.dankovtsev.smartcity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Column(name="status1")
    private String status1;
    @Column(name="status2")
    private String status2;

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

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
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
                ", status1='" + status1 + '\'' +
                ", status2='" + status2 + '\'' +
                '}';
    }
}
