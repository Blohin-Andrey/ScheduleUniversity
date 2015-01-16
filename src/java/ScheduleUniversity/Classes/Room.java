package ScheduleUniversity.Classes;

public class Room {

    private int id;
    private String number;
    private String type;
    private Boolean busy;

    public Room() {
        this.id = -1;
        this.number = "";
        this.type = "";
        this.busy = false;
    }

    public Room(int id, String number, String type, boolean busy) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.busy = busy;
    }

    public Room(Room room) {
        this.id = room.getId();
        this.number = room.getNumber();
        this.type = room.getType();
        this.busy = room.isBusy();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean isBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", number=" + number + ", type=" + type + ", busy=" + busy + '}';
    }

}
