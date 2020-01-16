package ru.dankovtsev.smartcity.model;



import javax.persistence.*;

@Entity
@Table(name = "checkserver")
public class Server {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String ip;
    @Column
    private String name;
    @Column
    private String status;

    public Server() {
    }

    public Server(String ip, String name, String status) {
        this.ip = ip;
        this.name = name;
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
