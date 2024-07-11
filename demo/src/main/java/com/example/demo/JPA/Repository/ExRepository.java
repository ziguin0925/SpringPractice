package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;


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
