package com.chegg.schoolsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Professor{
    private int id;
    private String name;
    private String email;
    private String school_name;
    private String course_taught;

    public Professor(int id, String name, String email, String school_name, String course_taught) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.school_name = school_name;
        this.course_taught = course_taught;
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

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getCourse_taught() {
        return course_taught;
    }

    public void setCourse_taught(String course_taught) {
        this.course_taught = course_taught;
    }
}
