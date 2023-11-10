package ru.kpfu.itis.kashshapov.repository;

import ru.kpfu.itis.kashshapov.entity.Sensor;
import ru.kpfu.itis.kashshapov.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SensorRepository implements Repository<Sensor> {
    @Override
    public Sensor get(Integer id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from sensors where id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Sensor sensor = null;
            if (resultSet != null) {
                resultSet.next();
                sensor = new Sensor(
                        resultSet.getInt("id"),
                        resultSet.getInt("sensor_type_id"),
                        resultSet.getBoolean("id_enabled"),
                        resultSet.getDate("installation_date")
                );
            }
            return sensor;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Sensor> getAll() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from sensors");
            ResultSet resultSet = statement.executeQuery();
            List<Sensor> sensors = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    sensors.add(new Sensor(
                            resultSet.getInt("id"),
                            resultSet.getInt("sensor_type_id"),
                            resultSet.getBoolean("id_enabled"),
                            resultSet.getDate("installation_date")
                    ));
                }
            }
            return sensors;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Sensor model) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into sensors (sensor_type_id, is_enabled, installation_date) values (?, ?, ?)");
            statement.setInt(1, model.getSensorTypeId());
            statement.setBoolean(2, model.getEnabled());
            statement.setDate(3, model.getInstallationDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Sensor model) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update sensors set is_enabled=? where id=?");
            statement.setBoolean(1, model.getEnabled());
            statement.setInt(2, model.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from sensors where id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Sensor getLast() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from sensors order by id desc limit 1");
            ResultSet resultSet = statement.executeQuery();
            Sensor sensor = null;
            if (resultSet != null) {
                while (resultSet.next()) {
                    sensor = new Sensor(
                            resultSet.getInt("id"),
                            resultSet.getInt("sensor_type_id"),
                            resultSet.getBoolean("id_enabled"),
                            resultSet.getDate("installation_date")
                    );
                }
            }
            return sensor;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
