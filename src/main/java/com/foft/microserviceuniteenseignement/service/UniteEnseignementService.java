package com.foft.microserviceuniteenseignement.service;

import com.foft.microserviceuniteenseignement.modele.UniteEnseignement;
import com.foft.microserviceuniteenseignement.repository.UniteEnseignementRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class UniteEnseignementService {

    @Autowired
    private UniteEnseignementRepository uniteEnseignementRepository;

    public UniteEnseignement saveUe(UniteEnseignement uniteEnseignement){
        return uniteEnseignementRepository.save(uniteEnseignement);
    }

    public Optional<UniteEnseignement> UniteEnseignement (Integer id){
        return uniteEnseignementRepository.findById(id);
    }
    public UniteEnseignement uniteEnseignementByIdClasse(Integer idClasse){
        return uniteEnseignementRepository.findByIdClasse(idClasse);
    }

    public Iterable<UniteEnseignement> uniteEnseignements (){
        return uniteEnseignementRepository.findAll();
    }

    public void deleteUniteEnseignement(Integer id){
        uniteEnseignementRepository.deleteById(id);
    }
}
