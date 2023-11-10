package ru.kpfu.itis.kashshapov.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/db_hackathon",
                        "postgres",
                        "ghbdtn_z_flvby"
                );
            }
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }

        return connection;
    }
}
