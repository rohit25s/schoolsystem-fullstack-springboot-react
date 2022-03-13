package com.chegg.schoolsystem.service;

import com.chegg.schoolsystem.dao.ProfessorRepository;
import com.chegg.schoolsystem.exceptions.ProfessorAlreadyPresentException;
import com.chegg.schoolsystem.model.Professor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private ProfessorRepository professorRepository;

    public ProfessorService(){
        professorRepository = new ProfessorRepository();
    }

    public Professor addProfessor(Professor professor) throws ProfessorAlreadyPresentException {
        return professorRepository.add(professor);
    }

    public List<Professor> getAllProfessors(Optional<String> schoolName) {
        return professorRepository.findAll(schoolName);
    }

    public Professor updateProfessor(int id, Professor professor){
        return professorRepository.update(id, professor);
    }

    public Professor getProfessor(int id){
        return professorRepository.get(id);
    }

    public void deleteProfessor(int id){
        professorRepository.delete(id);
    }



}
