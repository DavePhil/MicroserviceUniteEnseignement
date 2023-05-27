package com.foft.microserviceuniteenseignement.controller;

import com.foft.microserviceuniteenseignement.exceptions.ImpossibleToAdd;
import com.foft.microserviceuniteenseignement.exceptions.NotFoundException;
import com.foft.microserviceuniteenseignement.modele.Semestre;
import com.foft.microserviceuniteenseignement.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
public class SemestreController {
    @Autowired
    private SemestreService semestreService;

    @PostMapping("/semestre")
    public ResponseEntity<Semestre> createSemestre(@RequestBody Semestre semestre ){
        Semestre added = semestreService.saveSemestre(semestre);
        if (Objects.isNull(added)) throw new ImpossibleToAdd("Impossible d'ajouter cette unite d'enseignement");
        return new ResponseEntity<Semestre>(semestre, HttpStatus.CREATED);
    }

    @GetMapping("/semestre/{id}")
    public Optional<Semestre> getSemestre(@PathVariable("id") final Integer id ){
        Optional<Semestre> semestre = semestreService.getSemestre(id);
        if (!semestre.isPresent()) throw new NotFoundException("Cette Unite Enseignement n'est pas présent");
        return semestre;
    }

    @GetMapping("/semestres")
    public Iterable<Semestre> getSemestre() {
        return semestreService.getSemestres();
    }
}
