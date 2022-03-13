package com.chegg.schoolsystem;

import com.chegg.schoolsystem.controller.StudentController;
import com.chegg.schoolsystem.dao.StudentRepository;
import com.chegg.schoolsystem.exceptions.StudentAlreadyPresentException;
import com.chegg.schoolsystem.exceptions.StudentNotFoundException;
import com.chegg.schoolsystem.model.Student;
import com.chegg.schoolsystem.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentRunnerTest {

    StudentController studentController;
    StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        StudentService studentService =  new StudentService();
        studentRepository = new StudentRepository();
        studentController = new StudentController(studentService);
    }

    @Test
    void testAddGet() {
        Student s1 = new Student(1, "a", "b", "c");
        studentController.addStudent(s1);

        Student output = studentController.getStudent(1).getBody();
        assertEquals(output.getName(), "a");
    }

    @Test
    void testUpdate() {
        Student s1 = new Student(1, "a", "b", "c");
        studentController.addStudent(s1);

        s1.setName("b");
        studentController.updateStudent(s1.getId(), s1);
        Student output = studentController.getStudent(1).getBody();
        assertEquals(output.getName(), "b");
    }

    @Test
    void testDeleteAndList() {
        Student s1 = new Student(1, "a", "b", "c");
        studentController.addStudent(s1);

        Student s2 = new Student(2, "b", "c", "d");
        studentController.addStudent(s2);

        List<Student> res = studentController.getAllStudents(Optional.empty()).getBody();
        assertEquals(res.size(), 2);
        studentController.deleteStudent(1);
        res = studentController.getAllStudents(Optional.empty()).getBody();
        assertEquals(res.size(), 1);
    }

    @Test
    void testSearch() {
        Student s1 = new Student(1, "a", "b", "c");
        studentController.addStudent(s1);

        Student s2 = new Student(2, "b", "cd", "c");
        studentController.addStudent(s2);

        Student s3 = new Student(3, "bc", "cd", "d");
        studentController.addStudent(s3);

        List<Student> res = studentController.getAllStudents(Optional.empty()).getBody();
        assertEquals(res.size(), 3);

        res = studentController.getAllStudents(Optional.of("c")).getBody();
        assertEquals(res.size(), 2);
        res = studentController.getAllStudents(Optional.of("d")).getBody();
        assertEquals(res.size(), 1);
        res = studentController.getAllStudents(Optional.of("garbage")).getBody();
        assertEquals(res.size(), 0);
    }

    @Test
    void testErrors(){
        Student s1 = new Student(1, "a", "b", "c");
        studentController.addStudent(s1);
        Student s2 = new Student(1, "ad", "as", "E");

        assertThrows(StudentAlreadyPresentException.class, () -> {
            studentController.addStudent(s1);
        });

        assertThrows(StudentAlreadyPresentException.class, () -> {
            studentController.addStudent(s2);
        });

        assertThrows(StudentNotFoundException.class, () -> {
            studentController.getStudent(2);
        });

        assertThrows(StudentNotFoundException.class, () -> {
            studentController.deleteStudent(2);
        });

    }

}
