package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASSWORD = "tina"; // keep empty if your MySQL root has no password

    public static Connection getConnection() {

        Connection con = null;

        try {
            // Load MySQL 5.5 driver
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("✅ Database Connected Successfully");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL Driver not found");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("❌ Database Connection Failed");
            e.printStackTrace();
        }

        return con;
    }

    // Test connection
    public static void main(String[] args) {
        getConnection();
    }
}

