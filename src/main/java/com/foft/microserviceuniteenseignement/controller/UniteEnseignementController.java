package com.foft.microserviceuniteenseignement.controller;

import com.foft.microserviceuniteenseignement.bean.ClasseBean;
import com.foft.microserviceuniteenseignement.exceptions.ImpossibleToAdd;
import com.foft.microserviceuniteenseignement.exceptions.NotFoundException;
import com.foft.microserviceuniteenseignement.modele.Semestre;
import com.foft.microserviceuniteenseignement.modele.UniteEnseignement;
import com.foft.microserviceuniteenseignement.proxies.MicroserviceClasseProxy;
import com.foft.microserviceuniteenseignement.service.UniteEnseignementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("MicroUe")
public class UniteEnseignementController {

    @Autowired
    UniteEnseignementService uniteEnseignementService;
    @Autowired
    MicroserviceClasseProxy microserviceClasseProxy;

    @PostMapping("/ue")
    public ResponseEntity<UniteEnseignement> createUniteEnseignement(@RequestParam("semestre") Semestre semestre, @RequestParam("code") String code,  @RequestParam("idClasse") Integer idClasse){
        UniteEnseignement uniteEnseignement = new UniteEnseignement();
        uniteEnseignement.setCode(code);
        uniteEnseignement.setIdClasse(idClasse);
        uniteEnseignement.setSemestre(semestre);
        UniteEnseignement added = uniteEnseignementService.saveUe(uniteEnseignement);
        if (Objects.isNull(added)) throw new ImpossibleToAdd("Impossible d'ajouter cette unite d'enseignement");
        return new ResponseEntity<UniteEnseignement>(uniteEnseignement, HttpStatus.CREATED);
    }

    @GetMapping("/Ues")
    public Iterable<ClasseBean> ues (){
        return microserviceClasseProxy.getClasses();
    }

    @GetMapping("/ue/{id}")
    public Optional<UniteEnseignement> uniteEnseignement (@PathVariable("id") Integer id){
        Optional<UniteEnseignement> uniteEnseignement = uniteEnseignementService.UniteEnseignement(id);
        if (!uniteEnseignement.isPresent()) throw new NotFoundException("Cette Unite Enseignement n'est pas présent");
        return uniteEnseignement;
    }

    @GetMapping("/ues")
    public Iterable<UniteEnseignement> uniteEnseignements(){
        return uniteEnseignementService.uniteEnseignements();
    }

    @GetMapping("/ue/{idclasse}")
    public UniteEnseignement uniteEnseignementByClasse(@PathVariable("idclasse") Integer idClasse){
        return uniteEnseignementService.uniteEnseignementByIdClasse(idClasse);
    }

    @DeleteMapping("/ue/{id}")
    public void deleteUniteEnseignement(@PathVariable("id") Integer id){
        Optional<UniteEnseignement> uniteEnseignement = uniteEnseignementService.UniteEnseignement(id);
        if (!uniteEnseignement.isPresent()) throw new NotFoundException("Cette Unite Enseignement n'est pas présent");
        else uniteEnseignementService.deleteUniteEnseignement(id);

    }

    @GetMapping("/ue/{idClasse}/{idSemestre}")
    public List<UniteEnseignement> byIdClasseAndSemestre(@PathVariable("idClasse")Integer idClasse, @PathVariable("idSemestre") Integer idSemestre){
        return uniteEnseignementService.findByClasseAndSemestre(idClasse, idSemestre);
    }


}
