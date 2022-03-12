package com.chegg.schoolsystem.controller;

import com.chegg.schoolsystem.model.Student;
import com.chegg.schoolsystem.service.StudentService;
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
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return "student added, name:" + student.getName();
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> getAllStudents(@RequestParam Optional<String> schoolName){
        return studentService.getAllStudents(schoolName);
    }

    @RequestMapping(value="/student", method = RequestMethod.PUT)
    public String updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return "student updated: name" + student.getName();
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "Student Deleted";
    }

}
