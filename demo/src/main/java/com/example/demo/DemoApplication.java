package com.example.demo;

import com.example.demo.JPA.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.Date;


//@ServletComponentScan
@SpringBootApplication
public class DemoApplication {

	@Autowired
	EntityManagerFactory emf;

	public static void main(String[] args){
		//시작 클래스

//        웹 타입으로 실행 하지 않음.
//        SpringApplication app = new SpringApplication(DemoApplication.class);
//        app.setWebApplicationType(WebApplicationType.NONE);
//        app.run(args);

		SpringApplication.run(DemoApplication.class, args);
	}


//
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("emf = " + emf);
//
//
//		User user = new User();
//		EntityManager em = emf.createEntityManager();
//
//
//
//
//        EntityTransaction tx = em.getTransaction();
//
//
//        user.setId("demoApplication");
//        user.setName("akkailao");
//        user.setPassword("aaa");
//        user.setEmail("fff@aaa.com");
//        user.setInDate(new Date());
//        user.setUpDate(new Date());
//
//        try{
//            tx.begin();
//            em.persist(user);
//            tx.commit();
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally {
//            em.close();
//        }
//	}
}

