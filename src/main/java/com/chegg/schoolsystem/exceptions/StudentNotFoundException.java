package com.chegg.schoolsystem.exceptions;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(int id) {
        super("Student id not found : " + id);
    }
}
