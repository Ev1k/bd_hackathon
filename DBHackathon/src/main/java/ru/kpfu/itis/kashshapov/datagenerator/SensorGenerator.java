package ru.kpfu.itis.kashshapov.datagenerator;

import ru.kpfu.itis.kashshapov.entity.Sensor;
import ru.kpfu.itis.kashshapov.entity.SensorType;
import ru.kpfu.itis.kashshapov.repository.Repository;
import ru.kpfu.itis.kashshapov.repository.SensorRepository;
import ru.kpfu.itis.kashshapov.repository.SensorTypeRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class SensorGenerator {
    private final static Repository<SensorType> sensorTypeRepository = new SensorTypeRepository();
    private final static SensorRepository sensorRepository = new SensorRepository();
    public static void generateData() {
        ArrayList<SensorType> list = (ArrayList<SensorType>) sensorTypeRepository.getAll();

        Random random = new Random();

        int sensorTypeId = list.get(random.nextInt(list.size())).getId();

        boolean isEnabled = random.nextBoolean();

        Date installationDate = Date.valueOf(LocalDate.now());

        sensorRepository.add(new Sensor(sensorTypeId, isEnabled, installationDate));

        Sensor sensorWithId = sensorRepository.getLast();
        SensorStateGenerator.generateData(sensorWithId.getId());
    }
}
