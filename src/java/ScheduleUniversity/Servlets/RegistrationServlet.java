/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScheduleUniversity.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ScheduleUniversity.Classes.ConnectionJDBC;

/**
 *
 * @author User
 */
public class RegistrationServlet extends HttpServlet {

    private ConnectionJDBC connectionJdbc;

    @Override
    public void init() {
        connectionJdbc = new ConnectionJDBC();
        connectionJdbc.init();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String login = req.getParameter("Login");
        String password = req.getParameter("Password");
        String email = req.getParameter("EmailAddress");
        String firstName = req.getParameter("FirstName");
        String lastName = req.getParameter("LastName");
        String sex = req.getParameter("ChooseSex");
        int role = Integer.parseInt(req.getParameter("ChooseRole"));
        
        Connection connect = null;
        PreparedStatement statement = null;

        try {
            connect = connectionJdbc.getConnectionJDBC();

            if (exist(login)) {
                String messageError = "Such User Name has alredy existed";
                req.setAttribute("RegistrationError", messageError);
                req.getRequestDispatcher("/registration.jsp").forward(req, res);                
            } 
            else {                
                statement = connect.prepareStatement("INSERT INTO User(UserLogin, UserPassword, UserEmail, UserFirstName, UserSecondName, UserSex, RoleId) VALUES ('" + login + "','" + password + "','" + email + "','" + firstName + "','" + lastName + "','" + sex + "'," + role + ")");
                statement.executeUpdate();
                req.getRequestDispatcher("/index.jsp").forward(req, res);
            }
        }      
        catch (SQLException e) {
            e.printStackTrace();
        }       
        finally {
            if (statement != null) {
                try {
                    statement.close();
                }
                catch (SQLException ignore) {
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                }
                catch (SQLException ignore) {
                }
            }
        }
    }

    public boolean exist(String username) throws SQLException {
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean exist = false;

        try {
            connection = connectionJdbc.getConnectionJDBC();
            statement = connection.prepareStatement("SELECT UserLogin FROM User WHERE Userlogin = ?");
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            exist = resultSet.next();
        }
        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                }
                catch (SQLException ignore) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                }
                catch (SQLException ignore) {
                }
            }
        }

        return exist;
    }

}
