package com.foft.microserviceuniteenseignement.proxies;


import com.foft.microserviceuniteenseignement.bean.ClasseBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@FeignClient(name ="MicroserviceClasse", url = "http://localhost:9001")
public interface MicroserviceClasseProxy {
    @GetMapping("/classes")
    Iterable<ClasseBean> getClasses();
    @GetMapping("/classe/{id}")
    Optional<ClasseBean> getclasse (@PathVariable("id") final Integer id);
}
