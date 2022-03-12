package com.chegg.schoolsystem.controller;

import com.chegg.schoolsystem.model.Professor;
import com.chegg.schoolsystem.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ProfessorController {
    ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    @RequestMapping(value = "/professor", method = RequestMethod.POST )
    public String addProfessor(@RequestBody Professor professor){
        professorService.addProfessor(professor);
        return "professor added, name:" + professor.getName();
    }

    @RequestMapping(value = "/professor", method = RequestMethod.GET)
    public List<Professor> getAllProfessors(@RequestParam Optional<String> schoolName){
        return professorService.getAllProfessors(schoolName);
    }

    @RequestMapping(value="/professor", method = RequestMethod.PUT)
    public String updateProfessor(@RequestBody Professor professor){
        professorService.updateProfessor(professor);
        return "professor updated: name" + professor.getName();
    }

    @RequestMapping(value = "/professor/{id}", method = RequestMethod.GET)
    public Professor getProfessor(@PathVariable int id){
        return professorService.getProfessor(id);
    }

    @RequestMapping(value = "/professor/{id}", method = RequestMethod.DELETE)
    public String deleteProfessor(@PathVariable int id){
        professorService.deleteProfessor(id);
        return "Professor Deleted";
    }

}
