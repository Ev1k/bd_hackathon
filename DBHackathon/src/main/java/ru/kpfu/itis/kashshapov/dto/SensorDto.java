package ru.kpfu.itis.kashshapov.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class SensorDto {
    private int id;
    private String name;
    private Timestamp timestamp;
    private String value;
    private Boolean isEnabled;
    private Date installationDate;

    public SensorDto(int id, String name, Timestamp timestamp, String value, Boolean isEnabled, Date installationDate) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
        this.value = value;
        this.isEnabled = isEnabled;
        this.installationDate = installationDate;
    }

    public SensorDto(String name, Timestamp timestamp, String value, Boolean isEnabled, Date installationDate) {
        this.name = name;
        this.timestamp = timestamp;
        this.value = value;
        this.isEnabled = isEnabled;
        this.installationDate = installationDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Date getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {
        this.installationDate = installationDate;
    }
}
