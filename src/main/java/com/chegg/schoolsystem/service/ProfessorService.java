package com.chegg.schoolsystem.service;

import com.chegg.schoolsystem.dao.ProfessorRepository;
import com.chegg.schoolsystem.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public void addProfessor(Professor professor) {
        professorRepository.add(professor);
    }

    public List<Professor> getAllProfessors(Optional<String> school_name) {
        return professorRepository.findAll(school_name);
    }

    public void updateProfessor(Professor professor){
        professorRepository.update(professor);
    }

    public Professor getProfessor(int id){
        return professorRepository.get(id);
    }

    public void deleteProfessor(int id){
        professorRepository.delete(id);
    }



}
