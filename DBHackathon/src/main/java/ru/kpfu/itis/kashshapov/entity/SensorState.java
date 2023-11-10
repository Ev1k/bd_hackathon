package ru.kpfu.itis.kashshapov.entity;

import java.sql.Timestamp;

public class SensorState {
    private Integer id;
    private Integer SensorId;
    private Timestamp timestamp;
    private String value;

    public SensorState(Integer id, Integer sensorId, Timestamp timestamp, String value) {
        this.id = id;
        SensorId = sensorId;
        this.timestamp = timestamp;
        this.value = value;
    }

    public SensorState(Integer sensorId, Timestamp timestamp, String value) {
        SensorId = sensorId;
        this.timestamp = timestamp;
        this.value = value;
    }

    public SensorState() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSensorId() {
        return SensorId;
    }

    public void setSensorId(Integer sensorId) {
        SensorId = sensorId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
