/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class MySQLConnection {

    public Connection connection;

    public static final String URL = "jdbc:mysql://localhost:3306/university";
    public static final String USER = "root";
    public static final String PASSWORD = "admin";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    public MySQLConnection() { //Step 1: Load driver

        connection = null;

        try {
            Class.forName(DRIVER_CLASS);
            System.out.println("Successful: Driver has found");
        }
        catch (ClassNotFoundException ignore) {
            ignore.printStackTrace();
            System.out.println("Error: Driver has not found");
        }
    }

    private Connection createMySQLConnection() { //Step 2: Establish Java MSSQLServer connection

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Successful: Connected to Database.");
        }
        catch (SQLException ignore) {
            ignore.printStackTrace();
            System.out.println("Error: Unable to Connect to Database.");
        }
        return connection;
    }

    public void closeMySQLConnection() { //Step 3: Close Java MSSQLServer connection

        try {
            connection.close();
        }
        catch (SQLException ignore) {
            ignore.printStackTrace();
            System.out.println("Connection has not closed");
        }
    }

    public Connection getMSSQLConnection() {
        return createMySQLConnection();
    }

}
