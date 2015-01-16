package ScheduleUniversity.Classes;

public class Request {

    private Professor requester;
    private Subject discipline;
    private Group group;
    private String type;
    private int quantity;

    public Request() {
        requester = new Professor();
        discipline = new Subject();
        group = new Group();
        type = "";
        quantity = -1;
    }

    public Request(Professor requester, Subject discipline, Group group, String type, int quantity) {
        this.requester = requester;
        this.discipline = discipline;
        this.group = group;
        this.type = type;
        this.quantity = quantity;
    }

    public Professor getRequester() {
        return requester;
    }

    public void setRequester(Professor requester) {
        this.requester = requester;
    }

    public Subject getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Subject discipline) {
        this.discipline = discipline;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Request{" + "requester=" + requester + ", discipline=" + discipline + ", group=" + group + ", type=" + type + ", quantity=" + quantity + '}';
    }

}
