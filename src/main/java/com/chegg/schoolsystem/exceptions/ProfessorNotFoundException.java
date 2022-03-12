package com.chegg.schoolsystem.exceptions;

public class ProfessorNotFoundException extends RuntimeException{
    public ProfessorNotFoundException(int id) {
        super("Professor id not found : " + id);
    }
}
