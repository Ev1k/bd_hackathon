package ru.kpfu.itis.kashshapov.dao;

import ru.kpfu.itis.kashshapov.dto.SensorDto;
import ru.kpfu.itis.kashshapov.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SensorDao implements Dao<SensorDto>{
    private final Connection connection = DatabaseConnection.getConnection();
    @Override
    public SensorDto get(int id) {
        return null;
    }

    public List<SensorDto> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "select s.id, st.name, ss.timestamp, ss.value, s.is_enabled, s.installation_date from sensors s inner join sensor_types st on st.id = s.sensor_type_id inner join sensor_state ss on ss.sensor_id = s.id";
            ResultSet resultSet = statement.executeQuery(sql);
            List<SensorDto> sensors = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    sensors.add(
                            new SensorDto(resultSet.getInt("id"),
                                    resultSet.getString("name"),
                                    resultSet.getTimestamp("timestamp"),
                                    resultSet.getString("value"),
                                    resultSet.getBoolean("is_enabled"),
                                    resultSet.getDate("installation_date"))
                    );
                }
            }
            return sensors;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(SensorDto sensorDto) {

    }
}
