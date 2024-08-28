package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@//localhost:1521/ORCL";
        String username = "sys as sysdba";
        String password = "123456";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement()) {

            // Câu lệnh SQL để tạo bảng
            String sql = "CREATE TABLE Employees (" +
                    "ID NUMBER(5) PRIMARY KEY, " +
                    "Name VARCHAR2(100), " +
                    "Email VARCHAR2(50), " +
                    "Phone VARCHAR2(50), " +
                    "OrderNumber VARCHAR2(50)" +  // Changed column name from 'Number' to 'OrderNumber'
                    ")";


            // Thực thi câu lệnh tạo bảng
            statement.executeUpdate(sql);

            System.out.println("Bảng được tạo thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
