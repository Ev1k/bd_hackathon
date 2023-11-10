package ru.kpfu.itis.kashshapov.threads;

import ru.kpfu.itis.kashshapov.entity.Sensor;
import ru.kpfu.itis.kashshapov.entity.SensorState;
import ru.kpfu.itis.kashshapov.repository.SensorRepository;
import ru.kpfu.itis.kashshapov.repository.SensorStateRepository;
import ru.kpfu.itis.kashshapov.util.DatabaseConnection;

import java.sql.Timestamp;
import java.util.Random;

public class SensorUpdater extends Thread {
    private Sensor sensor;
    private SensorState state;
    private SensorRepository sensorRepository;
    private SensorStateRepository sensorStateRepository;
    private static final String[] colors = {"red", "green", "blue", "yellow", "purple", "orange"};

    public SensorUpdater(Sensor sensor, SensorState state) {
        this.sensor = sensor;
        this.state = state;
        sensorRepository = new SensorRepository();
        sensorStateRepository = new SensorStateRepository();
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(10000);
                synchronized (DatabaseConnection.getConnection()) {
                    if (sensor.getSensorTypeId() == 6) {
                        state.setTimestamp(new Timestamp(System.currentTimeMillis()));
                        String value = "{\"color\":" + '"' + colors[new Random().nextInt(colors.length)] + "\", \"intensity\":" + (new Random().nextInt(1, 101)) + "}";
                        state.setValue(value);
                    } else {
                        state.setTimestamp(new Timestamp(System.currentTimeMillis()));
                        state.setValue(new Random().nextBoolean() ? "1" : "0");
                    }
                    sensorStateRepository.update(state);
                }
            } catch (InterruptedException e) {
                System.out.println("I was occupied");
            }
        }
    }
}
