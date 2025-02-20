package db;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class DatabaseService {
    final String URL = "jdbc:postgresql://localhost:8080/database";
    final String DB_LOGIN = "user";
    final String DB_PASSWORD = "0305";

    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, DB_LOGIN, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
