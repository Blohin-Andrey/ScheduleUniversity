package ScheduleUniversity.Classes;

public class Professor extends User {

    public Professor() {

    }

    public Professor(String login, String password, String firstName, String secondName) {
        super(login, password, firstName, secondName);
    }

    public Professor(String login, String password, String email, String firstName, String secondName) {
        super(login, password, email, firstName, secondName);
    }

    public Professor(int id, String login, String password, String firstName, String secondName, String email, boolean sex, int role) {
        super(id, login, password, firstName, secondName, email, sex, role);
    }

}
