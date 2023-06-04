package com.foft.microserviceuniteenseignement.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ClasseBean {

    private Integer id;
    private String nom;
    private NiveauBean niveau;
    private SpecialiteBean specialite;

}
