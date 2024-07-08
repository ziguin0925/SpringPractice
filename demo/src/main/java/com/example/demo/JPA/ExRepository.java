package com.example.demo.JPA;

import com.example.demo.JPA.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class ExRepository {

    private EntityManager em;

    @Autowired
    public ExRepository(EntityManager em){
        this.em = em;

    }

    public void save(User user) {
        em.persist(user);
        //이거만 가능.

//        EntityTransaction tx = em.getTransaction();
//        try{
//            em.persist(user);
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally {
//            em.close();
//        }
    }
}
