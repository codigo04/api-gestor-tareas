package com.example.gestortareas.domain;


import java.time.LocalDateTime;
import java.util.List;

public class User {

    private int userId;
    private String name;
    private String lastName;
    private String password;
    private String gmail;
    private LocalDateTime dateRegustration;

    //private List<Projects> projects;

    public User(int userId, String name, String lastName, String password, String gmail, LocalDateTime dateRegustration) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.gmail = gmail;
        this.dateRegustration = dateRegustration;
    }

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public LocalDateTime getDateRegustration() {
        return dateRegustration;
    }

    public void setDateRegustration(LocalDateTime dateRegustration) {
        this.dateRegustration = dateRegustration;
    }


}
