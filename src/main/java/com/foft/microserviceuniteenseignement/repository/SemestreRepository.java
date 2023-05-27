package com.foft.microserviceuniteenseignement.repository;

import com.foft.microserviceuniteenseignement.modele.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepository extends JpaRepository<Semestre, Integer> {

}
