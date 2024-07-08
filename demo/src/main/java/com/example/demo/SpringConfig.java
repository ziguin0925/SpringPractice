package com.example.demo;

import com.example.demo.JPA.ExRepository;
import com.example.demo.JPA.ServiceEx;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private EntityManager em;


    @Autowired
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

//    @Autowired
//    public SpringConfig( EntityManager em) {
//        this.em = em;
//    }

    @Bean
    public ServiceEx memberService() {
        return new ServiceEx(ExRepository());
    }
    @Bean
    public ExRepository ExRepository() {
        return new ExRepository(em);
    }

    //...


}