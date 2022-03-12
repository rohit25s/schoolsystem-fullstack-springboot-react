package com.chegg.schoolsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = StudentAlreadyPresentException.class)
    public ResponseEntity studentPresentException(StudentAlreadyPresentException exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = ProfessorAlreadyPresentException.class)
    public ResponseEntity professorPresentException(ProfessorAlreadyPresentException exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = ProfessorNotFoundException.class)
    public ResponseEntity professorNotFoundException(ProfessorNotFoundException exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity studentNotFoundException(StudentNotFoundException exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
