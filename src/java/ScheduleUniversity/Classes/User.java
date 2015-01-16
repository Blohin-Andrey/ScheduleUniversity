/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScheduleUniversity.Classes;

/**
 *
 * @author User
 */
public class User {

    protected int id;
    private String login;
    private final String password;
    private String firstName;
    private String secondName;
    private String email;
    private boolean sex;
    private int role;

    public User(int id) {
        this.id = id;
        password = "";
    }

    public User() {
        id = -1;
        login = "";
        password = "";
        firstName = "";
        secondName = "";
        sex = false;
        role = -1;
    }

    public User(String login, String password, String firstName, String secondName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public User(String login, String password, String email, String firstName, String secondName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public User(int id, String login, String password, String firstName, String secondName, String email, boolean sex, int role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.sex = sex;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", login=" + login + ", password=" + password + ", firstName=" + firstName + ", secondName=" + secondName + ", email=" + email + ", sex=" + sex + ", role=" + role + '}';
    }

}
