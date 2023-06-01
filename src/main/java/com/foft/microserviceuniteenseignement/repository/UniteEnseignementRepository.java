package com.foft.microserviceuniteenseignement.repository;

import com.foft.microserviceuniteenseignement.modele.UniteEnseignement;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UniteEnseignementRepository extends JpaRepository<UniteEnseignement, Integer> {

    UniteEnseignement findByIdClasse(Integer idClasse);
    @Query("select ue from UniteEnseignement ue inner join Semestre se on se.id= ue.semestre.id where se.id=:idSemestre and ue.idClasse=:idClasse")
    List<UniteEnseignement> findByIdClasseAndSemestre(@Param("idClasse") Integer idClasse, @Param("idSemestre") Integer idSemestre);
}
