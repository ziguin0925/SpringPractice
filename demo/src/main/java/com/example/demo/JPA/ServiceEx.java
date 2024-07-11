package com.example.demo.JPA;


import com.example.demo.JPA.Entity.User;
import org.springframework.transaction.annotation.Transactional;
/*
* 스프링은 해당 클래스의 메서드를 실행할 때 트랜잭션을 시작하고, 메서드가 정상 종료되면 트랜잭션을 커
밋한다. 만약 런타임 예외가 발생하면 롤백한다.
JPA를 통한 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다
* */

//EntityTransaction tx = em.getTransaction(); 여기서 부터 트랜잭션 시작하는 듯.
@Transactional
public class ServiceEx {

    private final com.example.demo.JPA.Repository.ExRepository ExRepository;

    public ServiceEx(com.example.demo.JPA.Repository.ExRepository ExRepository) {
        this.ExRepository = ExRepository;
    }
    public void save(User user){
        ExRepository.save(user);
    }



}