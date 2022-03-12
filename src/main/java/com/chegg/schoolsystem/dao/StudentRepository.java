package com.chegg.schoolsystem.dao;

import com.chegg.schoolsystem.exceptions.StudentNotFoundException;
import com.chegg.schoolsystem.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    public Map<Integer, Student> studentMap = new HashMap<>();

    public void add(Student student){
        studentMap.put(student.getId(), student);
        return;
    }

    public List<Student> findAll(Optional<String> school_name){
        List<Student> result = new ArrayList<>(studentMap.values());
        if(school_name.isPresent()) {
            List<Student> resultBySchool = result
                    .stream()
                    .filter(s -> s.getSchool_name().contains(school_name.get()))
                    .collect(Collectors.toList());
            return resultBySchool;
        }
        return result;
    }

    public void update(Student student){
        Student oldStudent = studentMap.get(student.getId());
        if(student.getName()!=null)
            oldStudent.setName(student.getName());
        if(student.getEmail()!=null)
            oldStudent.setEmail(student.getEmail());
        if(student.getSchool_name()!=null)
            oldStudent.setSchool_name(student.getSchool_name());
    }

    public Student get(int id){
        if(studentMap.containsKey(id))
            return studentMap.get(id);
        else
            throw new StudentNotFoundException(id);
    }

    public void delete(int id){
        if(studentMap.containsKey(id))
            studentMap.remove(id);
        else
            throw new StudentNotFoundException(id);
    }
}
