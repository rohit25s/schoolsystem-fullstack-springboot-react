package com.chegg.schoolsystem.exceptions;

public class StudentAlreadyPresentException extends RuntimeException{
    public StudentAlreadyPresentException(int id) {
        super("Student with id " + id +" already present");
    }
}
