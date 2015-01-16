package ScheduleUniversity.Classes;

class Lesson {

    private Professor professor;
    private Group group;
    private Subject subject;
    private Room room;
    private String type;

    public Lesson() {
        professor = new Professor();
        group = new Group();
        subject = new Subject();
        room = new Room();
        type = "";
    }

    public Lesson(Professor professor, Group group, Subject subject, Room room, String type) {
        this.professor = professor;
        this.group = group;
        this.subject = subject;
        this.room = room;
        this.type = type;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Lesson{" + "professor=" + professor + ", group=" + group + ", subject=" + subject + ", room=" + room + ", type=" + type + '}';
    }

}
