package com.chegg.schoolsystem.controller;

import com.chegg.schoolsystem.exceptions.StudentAlreadyPresentException;
import com.chegg.schoolsystem.model.Student;
import com.chegg.schoolsystem.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST )
    public Student addStudent(@RequestBody Student student) throws StudentAlreadyPresentException{
        return studentService.addStudent(student);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudents(@RequestParam Optional<String> schoolName){
        List<Student> students = studentService.getAllStudents(schoolName);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(value="/student/{id}", method = RequestMethod.PUT)
    public Student updateStudent(@PathVariable int id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        Student student = studentService.getStudent(id);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return new ResponseEntity("Student Deleted", HttpStatus.OK);
    }

}
