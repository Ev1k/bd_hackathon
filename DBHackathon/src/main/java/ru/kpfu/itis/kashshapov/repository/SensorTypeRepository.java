package ru.kpfu.itis.kashshapov.repository;

import ru.kpfu.itis.kashshapov.entity.SensorType;
import ru.kpfu.itis.kashshapov.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SensorTypeRepository implements Repository<SensorType>{
    @Override
    public SensorType get(Integer id) {
        try(Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from sensor_types where id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            SensorType sensorType = null;
            if (resultSet != null) {
                resultSet.next();
                sensorType = new SensorType(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
            return sensorType;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<SensorType> getAll() {
        try(Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from sensor_types");
            ResultSet resultSet = statement.executeQuery();
            List<SensorType> sensor_types = new ArrayList<>();
            if (resultSet != null) {
                while(resultSet.next()) {
                    sensor_types.add(new SensorType(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    ));
                }
            }
            return sensor_types;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(SensorType model) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into sensor_types (name) values (?)");
            statement.setString(1, model.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(SensorType model) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update sensor_types set name=? where id=?");
            statement.setString(1, model.getName());
            statement.setInt(2, model.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from sensor_types where id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
