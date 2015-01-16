/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import ScheduleUniversity.Classes.Request;
import ScheduleUniversity.Classes.Room;
import java.util.List;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class DAOTest {

    public DAOTest() {
    }

    @Test
    public void testGetRequests() {
        System.out.println("getRequests");
        DAO instance = new DAO();
        List<Request> expResult = null;
        List<Request> result = instance.getRequests();
        for (Request item : result) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void testGetRooms() {
        System.out.println("getRooms");
        DAO instance = new DAO();
        List<Room> expResult = null;
        List<Room> result = instance.getRooms();
        for (Room item : result) {
            System.out.println(item.toString());
        }

    }

}
