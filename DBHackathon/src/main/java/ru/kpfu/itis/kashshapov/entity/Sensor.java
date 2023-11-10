package ru.kpfu.itis.kashshapov.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Sensor {
    private Integer id;
    private Integer SensorTypeId;
    private Boolean IsEnabled;
    private Date InstallationDate;

    public Sensor(Integer id, Integer sensorTypeId, Boolean isEnabled, Date installationDate) {
        this.id = id;
        SensorTypeId = sensorTypeId;
        IsEnabled = isEnabled;
        InstallationDate = installationDate;
    }

    public Sensor(Integer sensorTypeId, Boolean isEnabled, Date installationDate) {
        SensorTypeId = sensorTypeId;
        IsEnabled = isEnabled;
        InstallationDate = installationDate;
    }

    public Sensor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSensorTypeId() {
        return SensorTypeId;
    }

    public void setSensorTypeId(Integer sensorTypeId) {
        SensorTypeId = sensorTypeId;
    }

    public Boolean getEnabled() {
        return IsEnabled;
    }

    public void setEnabled(Boolean enabled) {
        IsEnabled = enabled;
    }

    public Date getInstallationDate() {
        return InstallationDate;
    }

    public void setInstallationDate(Date installationDate) {
        InstallationDate = installationDate;
    }
}
