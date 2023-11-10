package ru.kpfu.itis.kashshapov.datagenerator;

import ru.kpfu.itis.kashshapov.entity.Sensor;
import ru.kpfu.itis.kashshapov.entity.SensorState;
import ru.kpfu.itis.kashshapov.entity.SensorType;
import ru.kpfu.itis.kashshapov.repository.Repository;
import ru.kpfu.itis.kashshapov.repository.SensorRepository;
import ru.kpfu.itis.kashshapov.repository.SensorStateRepository;
import ru.kpfu.itis.kashshapov.repository.SensorTypeRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class SensorStateGenerator {
    private final static Repository<SensorType> sensorTypeRepository = new SensorTypeRepository();
    private final static Repository<SensorState> sensorStateRepository = new SensorStateRepository();
    private final static Repository<Sensor> sensorRepository = new SensorRepository();

    private final static String[] states = {"0", "1"};
    private final static String[] colors = {"red", "green", "blue", "yellow", "purple", "orange"};
    public static void generateData(int sensorId) {
        Random random = new Random();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Sensor sensor = sensorRepository.get(sensorId);
        int sensorTypeId = sensor.getSensorTypeId();
        String typeName = sensorTypeRepository.get(sensorTypeId).getName();

        String state;
        if (typeName.equals("Light Control Sensor")) {
            state = "{\"color\": " + "\"" + colors[random.nextInt(6)] + "\"" + ", \"intensity\": " + random.nextInt(1, 100) + "}";
        } else {
            state = states[random.nextInt(1)];
        }

        sensorStateRepository.add(new SensorState(sensorId, timestamp, state));
    }
}
