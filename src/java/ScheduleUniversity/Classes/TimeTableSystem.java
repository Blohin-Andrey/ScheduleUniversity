package ScheduleUniversity.Classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class TimeTableSystem {

    List<Request> requests;
    Map<Room, List<List<Lesson>>> lessons;
    List<Room> rooms;

    public TimeTableSystem(List<Request> requests, List<Room> rooms, int amountWorkingDays, int pairsInDay) {

        this.requests = requests;
        this.rooms = rooms;
        this.lessons = new HashMap<Room, List<List<Lesson>>>();

        for (int i = 0; i < rooms.size(); i++) {
            List<List<Lesson>> days = new ArrayList<List<Lesson>>(amountWorkingDays);
            for (int j = 0; j < amountWorkingDays; j++) {
                List<Lesson> pairs = new ArrayList<Lesson>(pairsInDay);
                for (int k = 0; k < pairsInDay; k++) {
                    pairs.add(null);
                }
                days.add(pairs);
            }
            lessons.put(rooms.get(i), days);
        }
    }

    public TimeTableSystem(List<Request> requests, Map<Room, List<List<Lesson>>> lessons, List<Room> rooms) {
        this.requests = requests;
        this.lessons = lessons;
        this.rooms = rooms;
    }

//    public List<Request> GetDataFromDB() {
//        try {
//            DAO d = new DAO();
//            return d.getRequests();
//        }
//        catch (SQLException ex) {
//            Logger.getLogger(TimeTableSystem.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        catch (ClassNotFoundException ex) {
//            Logger.getLogger(TimeTableSystem.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
    public void createSchedule(int amountDays, int amountPairs) {
        for (Request request : requests) {
            handleRequest(request, amountDays, amountPairs );
        }
    }

    void handleRequest(Request request, int amountDays, int amountPairs) {

        Professor professor = request.getRequester();
        Group group = request.getGroup();
        Subject subject = request.getDiscipline();
        String type = request.getType();
        Room room = null;

        Random random = new Random();

        int number = 0;
        int day = 0;
        int pair = 0;
        int i = 0;
        int count = request.getQuantity();

        while (i != count) {

            int amountRooms = lessons.size();

            List<Room> typeRooms = getTypeRooms(rooms, type);
            
            number = (int) (random.nextDouble() * typeRooms.size()); //Генерация идентификатора комнаты
            day = (int) (random.nextDouble() * amountDays); //Генерация идентификатора дня
            pair = (int) (random.nextDouble() * amountPairs); //Генерация идентификатора пары
            
            System.out.println("Max number: " + typeRooms.size() + ", current:" + number);
            room = typeRooms.get(number);

            Lesson lesson = new Lesson(professor, group, subject, room, type);

            if (lessons.get(room).get(day).get(pair) == null) {
                List<List<Lesson>> days = lessons.get(room);
                List<Lesson> pairs = days.get(day);
                pairs.add(pair, lesson);
                i++;
            }
        }
    }

    public int getTotalRooms(List<Room> rooms, String type) { //Gets amount of room equals to type
        int count = 0;
        for (Room item : rooms) {
            if (item.getType().equals(type)) {
                count++;
            }
        }
        return count;
    }

    public List<Room> getTypeRooms(List<Room> rooms, String type) {
        List<Room> typeRooms = new ArrayList<Room>();
        for (Room item : rooms) {
            if (item.getType().equals(type)) {
                typeRooms.add(item);
            }
        }
        return typeRooms;
    }

    public void printSchedule() {
        Set<Map.Entry<Room, List<List<Lesson>>>> set = lessons.entrySet();
        for (Map.Entry<Room, List<List<Lesson>>> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public Map<Room, List<List<Lesson>>> getLessons() {
        return lessons;
    }

    public void setLessons(Map<Room, List<List<Lesson>>> lessons) {
        this.lessons = lessons;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

}
