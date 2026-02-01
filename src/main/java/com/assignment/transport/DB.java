package com.assignment.transport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String URL = "jdbc:postgresql://localhost:5432/transport_db";
    private static final String USER = "postgres";
    private static final String PASS = "D2007201725"; // <-- поставь свой пароль

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
