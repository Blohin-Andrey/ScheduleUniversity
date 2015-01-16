/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ScheduleUniversity.Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ConnectionJDBC {
    
    private Connection connection;
    
    public ConnectionJDBC() {
        this.connection = null;     
    }
    
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "admin");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void close() {
        try {    
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConnectionJDBC() {
        return connection;
    }
        
}
