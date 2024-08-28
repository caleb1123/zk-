package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521/ORCL";
    private static final String USERNAME = "sys as sysdba";
    private static final String PASSWORD = "123456";

    // Phương thức để lấy kết nối
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
