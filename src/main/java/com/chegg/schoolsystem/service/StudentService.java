package com.chegg.schoolsystem.service;


import com.chegg.schoolsystem.dao.StudentRepository;
import com.chegg.schoolsystem.exceptions.StudentAlreadyPresentException;
import com.chegg.schoolsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) throws StudentAlreadyPresentException {
        return studentRepository.add(student);
    }

    public List<Student> getAllStudents(Optional<String> schoolName) {
        return studentRepository.findAll(schoolName);
    }

    public Student updateStudent(Student student){
        return studentRepository.update(student);
    }

    public Student getStudent(int id){
        return studentRepository.get(id);
    }

    public void deleteStudent(int id){
        studentRepository.delete(id);
    }
}
