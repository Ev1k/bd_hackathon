package ru.kpfu.itis.kashshapov.threads;

import ru.kpfu.itis.kashshapov.entity.Sensor;
import ru.kpfu.itis.kashshapov.entity.SensorState;
import ru.kpfu.itis.kashshapov.repository.SensorRepository;
import ru.kpfu.itis.kashshapov.repository.SensorStateRepository;

import java.util.List;

public class RunSensorUpdates {
    public static void main(String[] args) {
        List<SensorState> states = new SensorStateRepository().getAll();
        SensorRepository sensorRepository = new SensorRepository();
        for (SensorState i : states) {
            Sensor sensor = sensorRepository.get(i.getSensorId());
            new SensorUpdater(sensor, i).start();
        }
    }
}
