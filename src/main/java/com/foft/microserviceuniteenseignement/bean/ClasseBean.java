package com.foft.microserviceuniteenseignement.bean;

import com.foft.microserviceclasse.modele.Niveau;
import com.foft.microserviceclasse.modele.Specialite;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ClasseBean {

    private Integer id;
    private String nom;
    private Niveau niveau;
    private Specialite specialite;

}
