package com.chegg.schoolsystem.exceptions;

public class ProfessorAlreadyPresentException extends RuntimeException{
    public ProfessorAlreadyPresentException(int id) {
        super("Professor with id" + id +" already present");
    }
}
