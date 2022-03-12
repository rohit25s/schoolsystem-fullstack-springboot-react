package com.chegg.schoolsystem.dao;

import com.chegg.schoolsystem.exceptions.StudentAlreadyPresentException;
import com.chegg.schoolsystem.exceptions.StudentNotFoundException;
import com.chegg.schoolsystem.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    public Map<Integer, Student> studentMap = new HashMap<>();

    public Student add(Student student){
        if(studentMap.containsKey(student.getId()))
            throw new StudentAlreadyPresentException(student.getId());
        studentMap.put(student.getId(), student);
        return student;
    }

    public List<Student> findAll(Optional<String> schoolName){
        List<Student> result = new ArrayList<>(studentMap.values());
        if(schoolName.isPresent()) {
            List<Student> resultBySchool = result
                    .stream()
                    .filter(s -> s.getSchoolName().contains(schoolName.get()))
                    .collect(Collectors.toList());
            return resultBySchool;
        }
        return result;
    }

    public Student update(Student student){
        Student oldStudent = studentMap.get(student.getId());
        if(student.getName()!=null)
            oldStudent.setName(student.getName());
        if(student.getEmail()!=null)
            oldStudent.setEmail(student.getEmail());
        if(student.getSchoolName()!=null)
            oldStudent.setSchoolName(student.getSchoolName());
        return oldStudent;
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
