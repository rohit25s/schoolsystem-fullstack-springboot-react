package com.chegg.schoolsystem.service;


import com.chegg.schoolsystem.dao.StudentRepository;
import com.chegg.schoolsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.add(student);
    }

    public List<Student> getAllStudents(Optional<String> school_name) {
        return studentRepository.findAll(school_name);
    }

    public void updateStudent(Student student){
        studentRepository.update(student);
    }

    public Student getStudent(int id){
        return studentRepository.get(id);
    }

    public void deleteStudent(int id){
        studentRepository.delete(id);
    }
}
