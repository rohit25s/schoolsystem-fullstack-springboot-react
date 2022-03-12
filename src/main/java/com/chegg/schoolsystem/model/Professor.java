package com.chegg.schoolsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Professor{
    private int id;
    private String name;
    private String email;
    private String schoolName;
    private String courseTaught;

    public Professor(int id, String name, String email, String schoolName, String courseTaught) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.schoolName = schoolName;
        this.courseTaught = courseTaught;
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

    public void setSchoolName(String school_name) {
        this.schoolName = schoolName;
    }

    public String getCourseTaught() {
        return courseTaught;
    }

    public void setCourseTaught(String courseTaught) {
        this.courseTaught = courseTaught;
    }
}
