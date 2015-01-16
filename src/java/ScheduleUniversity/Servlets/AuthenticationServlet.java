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
public class AuthenticationServlet extends HttpServlet {

    private ConnectionJDBC connectionJdbc;

    @Override
    public void init() {
        connectionJdbc = new ConnectionJDBC();
        connectionJdbc.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int id;
        String group;
        String login = req.getParameter("Login");
        String password = req.getParameter("Password");
        String firstName;
        String secondName;
        String sex;
        String role;
        String page;

        try {

            if (checkLoginPassword(login, password)) {

                firstName = findFirstName(login);
                secondName = findSecondName(login);
                sex = findSex(login);
                role = findRole(login);
                id = findId(login);
                group = findGroup(login);

                req.setAttribute("UserId", id);
                req.setAttribute("UserLogin", login);
                req.setAttribute("UserFirstName", firstName);
                req.setAttribute("UserSecondName", secondName);
                req.setAttribute("UserSex", sex);
                req.setAttribute("UserGroup", group);

                page = "/" + role + ".jsp";

                req.getRequestDispatcher(page).forward(req, res);
            } else {
                page = "/index.jsp";
                req.getRequestDispatcher(page).forward(req, res);
            }

        }
        catch (SQLException ignore) {
            ignore.printStackTrace();
        }
        catch (ServletException ignore) {
            ignore.printStackTrace();
        }

    }

    public boolean checkLoginPassword(String login, String password) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean exist = false;

        try {
            connection = connectionJdbc.getConnectionJDBC();
            statement = connection.prepareStatement("SELECT UserLogin, UserPassword FROM User WHERE UserLogin = ? and UserPassword = ?");
            statement.setString(1, login);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            exist = resultSet.next();
        }
        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                }
                catch (SQLException ignore) {
                    ignore.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                }
                catch (SQLException ignore) {
                    ignore.printStackTrace();
                }
            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                }
//                catch (SQLException ignore) {
//                    ignore.printStackTrace();
//                }
//            }

        }

        return exist;
    }

    public String findRole(String login) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String role = "";

        try {
            connection = connectionJdbc.getConnectionJDBC();
            statement = connection.prepareStatement("SELECT RoleName FROM User AS u INNER JOIN Role AS r ON u.RoleId = r.RoleId AND UserLogin = ?");
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                role = resultSet.getString("RoleName");
            }
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

        return role;
    }

    public String findFirstName(String login) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String firstName = "";

        try {
            connection = connectionJdbc.getConnectionJDBC();
            statement = connection.prepareStatement("SELECT UserFirstName FROM User WHERE UserLogin = ?");
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                firstName = resultSet.getString("UserFirstName");
            }
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

        return firstName;
    }

    public String findSecondName(String login) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String secondName = "";

        try {
            connection = connectionJdbc.getConnectionJDBC();
            statement = connection.prepareStatement("SELECT UserSecondName FROM User WHERE UserLogin = ?");
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                secondName = resultSet.getString("UserSecondName");
            }
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

        return secondName;
    }

    public String findSex(String login) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sex = "";

        try {
            connection = connectionJdbc.getConnectionJDBC();
            statement = connection.prepareStatement("SELECT UserSex FROM User WHERE UserLogin = ?");
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                sex = resultSet.getString("UserSex");
            }
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

        return sex;
    }

    public String findGroup(String login) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String group = "";

        try {
            connection = connectionJdbc.getConnectionJDBC();
            statement = connection.prepareStatement("SELECT GroupName FROM User AS u INNER JOIN university.Group AS g ON u.GroupId = g.GroupId and UserLogin = ?");
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                group = resultSet.getString("GroupName");
            }
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

        return group;
    }

    public int findId(String login) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int Identificator = 0;

        try {
            connection = connectionJdbc.getConnectionJDBC();
            statement = connection.prepareStatement("SELECT UserId FROM User WHERE UserLogin = ?");
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Identificator = resultSet.getInt("UserId");
            }
        }
        finally {

            if (resultSet != null) {
                try {
                    resultSet.close();
                }
                catch (SQLException ignore) {
                    ignore.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                }
                catch (SQLException ignore) {
                    ignore.printStackTrace();
                }
            }
        }

        return Identificator;
    }

}
