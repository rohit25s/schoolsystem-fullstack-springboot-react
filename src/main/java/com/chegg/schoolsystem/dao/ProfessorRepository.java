package com.chegg.schoolsystem.dao;

import com.chegg.schoolsystem.exceptions.ProfessorAlreadyPresentException;
import com.chegg.schoolsystem.exceptions.ProfessorNotFoundException;
import com.chegg.schoolsystem.model.Professor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProfessorRepository {

    public Map<Integer, Professor> professorMap = new HashMap<>();

    public Professor add(Professor professor){
        if(professorMap.containsKey(professor.getId()))
            throw new ProfessorAlreadyPresentException(professor.getId());
        else {
            professorMap.put(professor.getId(), professor);
            return professor;
        }
    }

    public List<Professor> findAll(Optional<String> schoolName){
        List<Professor> result = new ArrayList<>(professorMap.values());
        if(schoolName.isPresent()) {
            List<Professor> resultBySchool = result
                    .stream()
                    .filter(p -> p.getSchoolName().contains(schoolName.get()))
                    .collect(Collectors.toList());
            return resultBySchool;
        }
        return result;
    }

    public Professor update(int id, Professor professor){
        if(professorMap.containsKey(id)) {
            Professor oldProfessor = professorMap.get(id);

            if (professor.getName() != null)
                oldProfessor.setName(professor.getName());
            if (professor.getEmail() != null)
                oldProfessor.setEmail(professor.getEmail());
            if (professor.getSchoolName() != null)
                oldProfessor.setSchoolName(professor.getSchoolName());
            if (professor.getCourseTaught() != null)
                oldProfessor.setCourseTaught(professor.getCourseTaught());
            return oldProfessor;
        }
        else
            throw new ProfessorNotFoundException(id);
    }

    public Professor get(int id){
        if(professorMap.containsKey(id))
            return professorMap.get(id);
        else
            throw new ProfessorNotFoundException(id);
    }

    public void delete(int id){
        if(professorMap.containsKey(id))
            professorMap.remove(id);
        else
            throw new ProfessorNotFoundException(id);
    }
}
