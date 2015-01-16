/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScheduleUniversity.Servlets;

import ScheduleUniversity.Classes.ConnectionJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class ApplicationServlet extends HttpServlet {

    private ConnectionJDBC connectionJdbc;

    @Override
    public void init() {
        connectionJdbc = new ConnectionJDBC();
        connectionJdbc.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String user = req.getParameter("User");
        String group = req.getParameter("ChooseGroup");
        String subject = req.getParameter("ChooseDiscipline");
        String pair = req.getParameter("RequisitionPairsInWeek");

        Connection connect = null;
        PreparedStatement statement = null;

        try {
            connect = connectionJdbc.getConnectionJDBC();
            statement = connect.prepareStatement("INSERT INTO Requisition(UserId, GroupId, DisciplineId, RequisitionPairsInWeek) VALUES ('" + user + "','" + group + "','" + subject + "','" + pair + "')");
            statement.executeUpdate();
            req.getRequestDispatcher("/teacher.jsp").forward(req, res);
        }
        catch (SQLException ignore) {
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

}
