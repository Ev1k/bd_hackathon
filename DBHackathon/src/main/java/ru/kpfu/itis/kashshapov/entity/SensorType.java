package ru.kpfu.itis.kashshapov.entity;

public class SensorType {
    private Integer id;
    private String name;

    public SensorType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public SensorType(String name) {
        this.name = name;
    }

    public SensorType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
