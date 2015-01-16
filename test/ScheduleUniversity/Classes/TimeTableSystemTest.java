/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScheduleUniversity.Classes;

import DataAccessLayer.DAO;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class TimeTableSystemTest {

    public TimeTableSystemTest() {
    }

    @Test
    public void testTotalRooms() {
        System.out.println("totalRooms");
        DAO dao = new DAO();
        List<Room> rooms = dao.getRooms();
        List<Request> requests = dao.getRequests();
        String type = "lecture";
        TimeTableSystem schedule = new TimeTableSystem(requests, rooms, 5, 4);
        int result = schedule.getTotalRooms(rooms, type);
        int expResult = 6;
        assertEquals(expResult, result);
        System.out.println("lecture: " + result);
    }

    @Test
    public void testGetTypeRooms() {
        System.out.println("getTypeRooms");
        DAO dao = new DAO();
        List<Room> rooms = dao.getRooms();
        List<Request> requests = dao.getRequests();
        String type = "lecture";
        TimeTableSystem schedule = new TimeTableSystem(requests, rooms, 5, 4);
        List<Room> result = schedule.getTypeRooms(rooms, type);
        for (Room item : result) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void testCreateSchedule() {
        System.out.println("createSchedule");
        final int days = 6;
        final int pairs = 6;

        DAO dao = new DAO();
        List<Room> rooms = dao.getRooms();
        List<Request> requests = dao.getRequests();

        TimeTableSystem schedule = new TimeTableSystem(requests, rooms, days, pairs);
        schedule.createSchedule(days, pairs);
        schedule.printSchedule();
    }

    @Test
    public void testGetTotalRooms() {
        System.out.println("getTotalRooms");
        List<Room> rooms = null;
        String type = "";
        TimeTableSystem instance = null;
        int expResult = 0;
        int result = instance.getTotalRooms(rooms, type);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPrintSchedule() {
        System.out.println("cdddddddddddddddddddddddddddddprintSchedule");
        TimeTableSystem instance = null;
//        instance.printSchedule();
    }

    @Test
    public void testGetRequests() {
        System.out.println("getRequests");
        TimeTableSystem instance = null;
        List<Request> expResult = null;
        List<Request> result = instance.getRequests();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetRequests() {
        System.out.println("setRequests");
        List<Request> requests = null;
        TimeTableSystem instance = null;
        instance.setRequests(requests);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLessons() {
        System.out.println("getLessons");
        TimeTableSystem instance = null;
        Map<Room, List<List<Lesson>>> expResult = null;
        Map<Room, List<List<Lesson>>> result = instance.getLessons();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetLessons() {
        System.out.println("setLessons");
        Map<Room, List<List<Lesson>>> lessons = null;
        TimeTableSystem instance = null;
        instance.setLessons(lessons);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetRooms() {
        System.out.println("getRooms");
        TimeTableSystem instance = null;
        List<Room> expResult = null;
        List<Room> result = instance.getRooms();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetRooms() {
        System.out.println("setRooms");
        List<Room> rooms = null;
        TimeTableSystem instance = null;
        instance.setRooms(rooms);
        fail("The test case is a prototype.");
    }
}
