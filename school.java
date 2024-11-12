/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */



package javaapplication38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class JavaApplication38 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yash23";  // Ensure the database 'yash23' exists
        String user = "root";
        String password = "12345678";  // Change this to your actual MySQL password

        // SQL query to create the 'students' table
        String createTableSQL = "CREATE TABLE IF NOT EXISTS students ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(100) NOT NULL, "
                + "age INT NOT NULL, "
                + "grade VARCHAR(50), "
                + "email VARCHAR(100));";

        // Load the MySQL JDBC Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // MySQL Connector 8.x
            System.out.println("MySQL JDBC Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: MySQL JDBC Driver not found.");
            e.printStackTrace();
            return;
        }

        // Establish a connection and execute the query
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            // Execute the SQL statement to create the table
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'students' created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while creating the table.");
        }
    }
}

