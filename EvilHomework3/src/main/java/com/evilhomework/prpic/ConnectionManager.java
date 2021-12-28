package com.evilhomework.prpic;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private Connection connection;

    public ConnectionManager() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }

    public Connection getConnection() {

        if(this.connection != null) {
            return connection;
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dogsdb", "dogs-db", "test-pass");
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        this.connection = conn;
        return conn;
    }
}