package com.example.demo.JPA;

import com.example.demo.JPA.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class ExJpa implements CommandLineRunner {

    @Autowired
    EntityManagerFactory emf;

    public void exJpa(){
        EntityManager em =emf.createEntityManager();
        User user = new User();

        EntityTransaction tx = em.getTransaction();


        user.setName("akkailao");
        user.setPassword("aaa");
        user.setEmail("fff@aaa.com");
        user.setInDate(new Date());
        user.setUpDate(new Date());

        try{
            tx.begin();
            em.persist(user);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(emf);
    }
}
