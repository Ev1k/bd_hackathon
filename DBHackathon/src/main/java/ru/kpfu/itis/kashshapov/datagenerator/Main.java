package ru.kpfu.itis.kashshapov.datagenerator;

import ru.kpfu.itis.kashshapov.entity.Sensor;
import ru.kpfu.itis.kashshapov.repository.Repository;
import ru.kpfu.itis.kashshapov.repository.SensorRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static SensorRepository sensorRepository = new SensorRepository();

    public static void main(String[] args) {

        Sensor motionSensor = new Sensor(1, true, Date.valueOf(LocalDate.now()));
        sensorRepository.add(motionSensor);
        Sensor motionSensorWithId = sensorRepository.getLast();
        SensorStateGenerator.generateData(motionSensorWithId.getId());



        Sensor waterLeakSensor = new Sensor(2, true, Date.valueOf(LocalDate.now()));
        Sensor windowSensor = new Sensor(3, true, Date.valueOf(LocalDate.now()));
        Sensor curtainSensor = new Sensor(4, true, Date.valueOf(LocalDate.now()));
        Sensor smokeSensor = new Sensor(5, true, Date.valueOf(LocalDate.now()));
        Sensor lightingSensor = new Sensor(6, true, Date.valueOf(LocalDate.now()));

        List<Sensor> sensorList = new ArrayList<>();

        sensorList.add(motionSensor);
        sensorList.add(windowSensor);
        sensorList.add(waterLeakSensor);
        sensorList.add(curtainSensor);
        sensorList.add(smokeSensor);
        sensorList.add(lightingSensor);

        for (Sensor s : sensorList) {
            sensorRepository.add(s);
            Sensor sensorWithId = sensorRepository.getLast();
            SensorStateGenerator.generateData(sensorWithId.getId());
        }
    }



}