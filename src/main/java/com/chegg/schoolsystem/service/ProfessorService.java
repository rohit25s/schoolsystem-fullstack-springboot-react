package com.chegg.schoolsystem.service;

import com.chegg.schoolsystem.dao.ProfessorRepository;
import com.chegg.schoolsystem.exceptions.ProfessorAlreadyPresentException;
import com.chegg.schoolsystem.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor addProfessor(Professor professor) throws ProfessorAlreadyPresentException {
        return professorRepository.add(professor);
    }

    public List<Professor> getAllProfessors(Optional<String> schoolName) {
        return professorRepository.findAll(schoolName);
    }

    public Professor updateProfessor(Professor professor){
        return professorRepository.update(professor);
    }

    public Professor getProfessor(int id){
        return professorRepository.get(id);
    }

    public void deleteProfessor(int id){
        professorRepository.delete(id);
    }



}
