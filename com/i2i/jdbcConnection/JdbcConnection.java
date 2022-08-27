package com.i2i.jdbcConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class JdbcConnection {

    private static Connection connection = null;
    private static JdbcConnection jdbcConnection;
    private static final String URL = "jdbc:mysql://localhost:3306/employee_management_portal";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Jubair@1999";


    private JdbcConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            jdbcConnection = new JdbcConnection();
        }
        return connection;
    }
}