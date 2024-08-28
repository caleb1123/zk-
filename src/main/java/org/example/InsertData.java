package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@//localhost:1521/ORCL";
        String username = "sys as sysdba";
        String password = "123456";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement()) {

            // Câu lệnh SQL để chèn dữ liệu
            String sql = "INSERT ALL " +
                    "INTO Employees (ID, Name, Email, Phone, OrderNumber) VALUES (1, 'John Doe', 'john.doe@example.com', '123-456-7890', '001') " +
                    "INTO Employees (ID, Name, Email, Phone, OrderNumber) VALUES (2, 'Jane Smith', 'jane.smith@example.com', '123-456-7891', '002') " +
                    "INTO Employees (ID, Name, Email, Phone, OrderNumber) VALUES (3, 'Michael Brown', 'michael.brown@example.com', '123-456-7892', '003') " +
                    "INTO Employees (ID, Name, Email, Phone, OrderNumber) VALUES (4, 'Emily Davis', 'emily.davis@example.com', '123-456-7893', '004') " +
                    "INTO Employees (ID, Name, Email, Phone, OrderNumber) VALUES (5, 'Sarah Wilson', 'sarah.wilson@example.com', '123-456-7894', '005') " +
                    "SELECT * FROM dual";

            // Thực thi câu lệnh chèn dữ liệu
            int rowsAffected = statement.executeUpdate(sql);

            System.out.println("Dữ liệu đã được chèn thành công! Số dòng bị ảnh hưởng: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
