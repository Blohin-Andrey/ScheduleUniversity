/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScheduleUniversity.Servlets;

import DataAccessLayer.DAO;
import ScheduleUniversity.Classes.Request;
import ScheduleUniversity.Classes.Room;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ScheduleUniversity.Classes.TimeTableSystem;
import java.util.List;

/**
 *
 * @author User
 */
public class ScheduleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        final int days = 6;
        final int pairs = 6;
//        final int rooms = 10;

        DAO dao = new DAO();
        List<Room> rooms = dao.getRooms();
        List<Request> requests = dao.getRequests();

        TimeTableSystem schedule = new TimeTableSystem(requests, rooms, days, pairs);
        schedule.createSchedule(days,pairs);
        schedule.printSchedule();
//        schedule.exportSchedule();
//        System.out.println("ddddddddddd");
        req.getRequestDispatcher("/schedule.jsp").forward(req, res);
    }

}
