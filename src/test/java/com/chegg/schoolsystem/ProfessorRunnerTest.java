package com.chegg.schoolsystem;

import com.chegg.schoolsystem.controller.ProfessorController;
import com.chegg.schoolsystem.dao.ProfessorRepository;
import com.chegg.schoolsystem.exceptions.ProfessorAlreadyPresentException;
import com.chegg.schoolsystem.exceptions.ProfessorNotFoundException;
import com.chegg.schoolsystem.model.Professor;
import com.chegg.schoolsystem.service.ProfessorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ProfessorRunnerTest {

    ProfessorController professorController;
    ProfessorRepository professorRepository;

    @BeforeEach
    void setUp() {

        ProfessorService professorService = new ProfessorService();
        professorRepository = new ProfessorRepository();
        professorController = new ProfessorController(professorService);
    }

    @Test
    void testAddGet() {
        Professor s1 = new Professor(1, "a", "b", "c", "S");
        professorController.addProfessor(s1);

        Professor output = professorController.getProfessor(1).getBody();
        assertEquals(output.getName(), "a");
    }

    @Test
    void testUpdate() {
        Professor s1 = new Professor(1, "a", "b", "c", "S");
        professorController.addProfessor(s1);

        s1.setName("b");
        professorController.updateProfessor(s1.getId(), s1);
        Professor output = professorController.getProfessor(1).getBody();
        assertEquals(output.getName(), "b");
    }

    @Test
    void testDeleteAndList() {
        Professor s1 = new Professor(1, "a", "b", "c", "S");
        professorController.addProfessor(s1);

        Professor s2 = new Professor(2, "b", "c", "d", "S");
        professorController.addProfessor(s2);

        List<Professor> res = professorController.getAllProfessors(Optional.empty()).getBody();
        assertEquals(res.size(), 2);
        professorController.deleteProfessor(1);
        res = professorController.getAllProfessors(Optional.empty()).getBody();
        assertEquals(res.size(), 1);
    }

    @Test
    void testSearch() {
        Professor s1 = new Professor(1, "a", "b", "c", "E");
        professorController.addProfessor(s1);

        Professor s2 = new Professor(2, "b", "cd", "c", "EA");
        professorController.addProfessor(s2);

        Professor s3 = new Professor(3, "bc", "cd", "d", "ER");
        professorController.addProfessor(s3);

        List<Professor> res = professorController.getAllProfessors(Optional.empty()).getBody();
        assertEquals(res.size(), 3);

        res = professorController.getAllProfessors(Optional.of("c")).getBody();
        assertEquals(res.size(), 2);
        res = professorController.getAllProfessors(Optional.of("d")).getBody();
        assertEquals(res.size(), 1);
        res = professorController.getAllProfessors(Optional.of("garbage")).getBody();
        assertEquals(res.size(), 0);
    }

    @Test
    void testErrors(){
        Professor s1 = new Professor(1, "a", "b", "c", "E");
        professorController.addProfessor(s1);
        Professor s2 = new Professor(1, "ad", "as", "E", "D");

        assertThrows(ProfessorAlreadyPresentException.class, () -> {
            professorController.addProfessor(s1);
        });

        assertThrows(ProfessorAlreadyPresentException.class, () -> {
            professorController.addProfessor(s2);
        });

        assertThrows(ProfessorNotFoundException.class, () -> {
            professorController.getProfessor(2);
        });

        assertThrows(ProfessorNotFoundException.class, () -> {
            professorController.deleteProfessor(2);
        });

    }

}
