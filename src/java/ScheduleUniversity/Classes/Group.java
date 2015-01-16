/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScheduleUniversity.Classes;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Group {

    private int id;
    private String name;
    private ArrayList<User> students;

    public Group() {
        id = -1;
        name = "";
        students = new ArrayList<User>();
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<User> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" + "id=" + id + ", name=" + name + ", students=" + students + '}';
    }

}
