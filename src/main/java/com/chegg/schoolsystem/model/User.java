package com.chegg.schoolsystem.model;

public abstract class User {
    private int id;
    private String name;
    private String email;
    private String schoolName;

    public User(int id, String name, String email, String schoolName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.schoolName = schoolName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
