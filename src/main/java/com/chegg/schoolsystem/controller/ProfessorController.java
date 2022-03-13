package com.chegg.schoolsystem.controller;

import com.chegg.schoolsystem.model.Professor;
import com.chegg.schoolsystem.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Professor addProfessor(@RequestBody Professor professor){
        return professorService.addProfessor(professor);
    }

    @RequestMapping(value = "/professor", method = RequestMethod.GET)
    public ResponseEntity<List<Professor>> getAllProfessors(@RequestParam Optional<String> schoolName){
        List<Professor> professors = professorService.getAllProfessors(schoolName);
        return new ResponseEntity(professors, HttpStatus.OK);
    }

    @RequestMapping(value="/professor/{id}", method = RequestMethod.PUT)
    public Professor updateProfessor(@PathVariable int id, @RequestBody Professor professor){
        return professorService.updateProfessor(id, professor);
    }

    @RequestMapping(value = "/professor/{id}", method = RequestMethod.GET)
    public ResponseEntity<Professor> getProfessor(@PathVariable int id){
        Professor professor = professorService.getProfessor(id);
        return new ResponseEntity(professor, HttpStatus.OK);
    }

    @RequestMapping(value = "/professor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProfessor(@PathVariable int id){
        professorService.deleteProfessor(id);
        return new ResponseEntity("Professor Deleted", HttpStatus.OK);
    }

}
