package com.foft.microserviceuniteenseignement.repository;

import com.foft.microserviceuniteenseignement.modele.UniteEnseignement;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniteEnseignementRepository extends JpaRepository<UniteEnseignement, Integer> {
}
