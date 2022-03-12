package com.chegg.schoolsystem.dao;

import com.chegg.schoolsystem.exceptions.ProfessorNotFoundException;
import com.chegg.schoolsystem.model.Professor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProfessorRepository {

    public Map<Integer, Professor> professorMap = new HashMap<>();

    public void add(Professor professor){
        professorMap.put(professor.getId(), professor);
        return;
    }

    public List<Professor> findAll(Optional<String> school_name){
        List<Professor> result = new ArrayList<>(professorMap.values());
        if(school_name.isPresent()) {
            List<Professor> resultBySchool = result
                    .stream()
                    .filter(p -> p.getSchool_name().contains(school_name.get()))
                    .collect(Collectors.toList());
            return resultBySchool;
        }
        return result;
    }

    public void update(Professor professor){
        Professor oldProfessor = professorMap.get(professor.getId());
        if(professor.getName()!=null)
            oldProfessor.setName(professor.getName());
        if(professor.getEmail()!=null)
            oldProfessor.setEmail(professor.getEmail());
        if(professor.getSchool_name()!=null)
            oldProfessor.setSchool_name(professor.getSchool_name());
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
