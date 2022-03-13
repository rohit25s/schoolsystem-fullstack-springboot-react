package com.chegg.schoolsystem.model;

public class Professor extends User{
    private String courseTaught;

    public Professor(int id, String name, String email, String schoolName, String courseTaught) {
       super(id, name, email, schoolName);
        this.courseTaught = courseTaught;
    }
    public String getCourseTaught() {
        return courseTaught;
    }

    public void setCourseTaught(String courseTaught) {
        this.courseTaught = courseTaught;
    }
}
