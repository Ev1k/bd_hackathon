package ru.kpfu.itis.kashshapov.repository;

import ru.kpfu.itis.kashshapov.entity.Sensor;
import ru.kpfu.itis.kashshapov.entity.SensorState;
import ru.kpfu.itis.kashshapov.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SensorStateRepository implements Repository<SensorState> {
    @Override
    public SensorState get(Integer id) {
        try(Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from sensor_state where id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            SensorState sensor = null;
            if (resultSet != null) {
                resultSet.next();
                sensor = new SensorState(
                        resultSet.getInt("id"),
                        resultSet.getInt("sensor_id"),
                        resultSet.getTimestamp("timestamp"),
                        resultSet.getString("value")
                );
            }
            return sensor;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<SensorState> getAll() {
        try(Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from sensor_state");
            ResultSet resultSet = statement.executeQuery();
            List<SensorState> sensors = new ArrayList<>();
            if (resultSet != null) {
                while(resultSet.next()) {
                    sensors.add(new SensorState(
                            resultSet.getInt("id"),
                            resultSet.getInt("sensor_id"),
                            resultSet.getTimestamp("timestamp"),
                            resultSet.getString("value")
                    ));
                }
            }
            return sensors;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(SensorState model) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into sensor_state (sensor_id, timestamp, value) values  (?, ?, ?)");
            statement.setInt(1, model.getSensorId());
            statement.setTimestamp(2, model.getTimestamp());
            statement.setString(3, model.getValue());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(SensorState model) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update sensor_state set value=? where id=?");
            statement.setString(1, model.getValue());
            statement.setInt(2, model.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from sensor_state where id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
