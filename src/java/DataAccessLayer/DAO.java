package DataAccessLayer;

import ScheduleUniversity.Classes.ConnectionJDBC;
import ScheduleUniversity.Classes.Group;
import ScheduleUniversity.Classes.Professor;
import ScheduleUniversity.Classes.Request;
import ScheduleUniversity.Classes.Room;
import ScheduleUniversity.Classes.Subject;
import ScheduleUniversity.Classes.TimeTableSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    private Connection connect;

    public DAO() {
        this.connect = new MySQLConnection().getMSSQLConnection();
    }

    public List<Request> getRequests() {

        Statement st = null;
        ResultSet rs = null;

        List<Request> requests = new ArrayList<Request>();

        try {

            st = connect.createStatement();
            rs = st.executeQuery(""
                    + "SELECT \n"
                    + "    us.UserId,\n"
                    + "    us.UserLogin,\n"
                    + "    us.UserPassword,\n"
                    + "    us.UserEmail,\n"
                    + "    us.UserFirstName,\n"
                    + "    us.UserSecondName,\n"
                    + "    us.UserSex,\n"
                    + "    us.RoleId,\n"
                    + "    dis.DisciplineId,\n"
                    + "    dis.DisciplineName,\n"
                    + "    gr.GroupId,\n"
                    + "    gr.GroupName,\n"
                    + "    req.RequisitionQuantity,\n"
                    + "    typ.TypeSubjectId,\n"
                    + "    typ.TypeSubjectName\n"
                    + "FROM\n"
                    + "    Requisition As req\n"
                    + "        INNER JOIN\n"
                    + "    User As us ON req.UserId = us.UserId\n"
                    + "        INNER JOIN\n"
                    + "    Discipline As dis ON req.DisciplineId = dis.DisciplineId\n"
                    + "        INNER JOIN\n"
                    + "    university.Group As gr ON req.GroupId = gr.GroupId\n"
                    + "        INNER JOIN\n"
                    + "    TypeSubject As typ ON req.TypeSubjectId = typ.typesubjectId");
            if (rs.isLast()) {
                System.out.println("Table is empty");
            } else {
                while (rs.next()) {

                    Professor professor = new Professor(
                            Integer.parseInt(rs.getString("UserId")),
                            rs.getString("UserLogin"),
                            rs.getString("UserPassword"),
                            rs.getString("UserEmail"),
                            rs.getString("UserFirstName"),
                            rs.getString("UserSecondName"),
                            Boolean.parseBoolean(rs.getString("UserSex")),
                            Integer.parseInt(rs.getString("RoleId"))
                    );

                    Subject subject = new Subject(
                            Integer.parseInt(rs.getString("DisciplineId")),
                            rs.getString("DisciplineName")
                    );

                    Group group = new Group(
                            Integer.parseInt(rs.getString("GroupId")),
                            rs.getString("GroupName")
                    );

                    String type = rs.getString("TypeSubjectName");
                    int quality = Integer.parseInt(rs.getString("RequisitionQuantity"));

                    Request request = new Request(professor, subject, group, type, quality);

                    requests.add(request);
                }
            }
        }
        catch (SQLException ignore) {
            ignore.printStackTrace();
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            }
            catch (SQLException ignore) {
                System.out.println("ResultSet hasn't completed");
                ignore.printStackTrace();
            }
            try {
                if (st != null) {
                    st.close();
                }
            }
            catch (SQLException ignore) {
                System.out.println("Statement hasn't completed");
                ignore.printStackTrace();
            }
        }

        return requests;

    }

    public List<Room> getRooms() {

        Statement st = null;
        ResultSet rs = null;

        List<Room> rooms = new ArrayList<Room>();

        try {

            st = connect.createStatement();
            rs = st.executeQuery("SELECT AudienceId, AudienceNumber, AudienceType FROM audience;");
            if (rs.isLast()) {
                System.out.println("Table is empty");
            } else {
                while (rs.next()) {

                    Room room = new Room(
                            Integer.parseInt(rs.getString("AudienceId")),
                            rs.getString("AudienceNumber"),
                            rs.getString("AudienceType"),
                            false);
                    rooms.add(room);
                }

            }
        }
        catch (SQLException ignore) {
            ignore.printStackTrace();
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            }
            catch (SQLException ignore) {
                System.out.println("ResultSet hasn't completed");
                ignore.printStackTrace();
            }
            try {
                if (st != null) {
                    st.close();
                }
            }
            catch (SQLException ignore) {
                System.out.println("Statement hasn't completed");
                ignore.printStackTrace();
            }
        }

        return rooms;
    }
    
//    public void exportSchedule(TimeTableSystem schedule) {
//            
//            PreparedStatement ps = null;
//            ResultSet rs = null;
//            
//            try {
//                
//                int amountRooms = schedule.getLessons().size();
//                int amountDays = schedule.getLessons().values().size();
//                int amountPairs = schedule.getLessons().values().size();
//                
//                                List<List<Lesson>> days = lessons.get(room);
//                List<Lesson> pairs = days.get(day);
//                pairs.add(pair, lesson);
//                
//                for (int room = 0; room < schedule.getLessons().size(); room++) {
//                    for (int pair = 0; pair < days[day].pairs.length; pair++) {
//                        for (int room = 0; room < days[day].pairs[pair].getRooms().size(); room++) {
//                            ps = con.prepareStatement("INSERT INTO Lesson(LessonTeacher, LessonGroup, LessonDiscipline, LessonDayOfWeek, LessonPair, AudienceId) "
//                                    + " VALUES( "
//                                    + days[day].pairs[pair].getRooms().get(room).getTeacher().getId() + ", "
//                                    + days[day].pairs[pair].getRooms().get(room).getGroupId() + ", "
//                                    + days[day].pairs[pair].getRooms().get(room).getDisciplineId() + ", "
//                                    + (day + 1) + ", "
//                                    + (pair + 1) + ", "
//                                    + (room + 1) + ");");
//                            ps.execute();
//                        }
//                    }
//                }
//            }
//            catch (SQLException ignore) {
//                ignore.printStackTrace();
//            }
//        }
    

    public void closeDAO() {
        try {
            connect.close();
        }
        catch (SQLException ignore) {
            ignore.printStackTrace();
            System.out.println("Connection has not closed");
        }
    }
}
