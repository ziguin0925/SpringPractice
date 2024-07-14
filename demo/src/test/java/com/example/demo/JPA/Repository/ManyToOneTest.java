package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.*;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
class ManyToOneTest {
    //@Transactional을 사용하게 되면 해당 클래스의 전체가 트랜잭션 처리됨.
    //트랜잭션 처리를 제대로 해주지 않으면 메서드 들이 트랜잭션 세션에 접근하지 못하거나
    // 제대로된 데이터가 나오지 않을 수 있음.



    @Autowired
    EntityManager em;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepositoryMany boardRepository;


    @Test
    @Order(1)
    @DisplayName("Board, User 객체 만들고 저장")
    public void test() {
        // 1. 테스트 데이터 작성
        User user = new User();
        user.setId("aaa");
        user.setPassword("1234");
        user.setName("LEE");
        user.setEmail("aaa@aaa.com");
        user.setInDate(new Date());
        user.setUpDate(new Date());
        userRepository.save(user);

        BoardMany b1 = new BoardMany();
        b1.setId(1L);
        b1.setTitle("title1");
        b1.setContent("content1");
        b1.setUser(user);
        b1.setViewCnt(0L);
        b1.setInDate(new Date());
        b1.setUpDate(new Date());
        boardRepository.save(b1);

        BoardMany b2 = new BoardMany();
        b2.setId(2L);
        b2.setTitle("title2");
        b2.setContent("content2");
        b2.setUser(user);
        b2.setViewCnt(0L);
        b2.setInDate(new Date());
        b2.setUpDate(new Date());
        boardRepository.save(b2);

        b1 = boardRepository.findById(1L).orElse(null);
        b2 = boardRepository.findById(2L).orElse(null);


        //Board의 toString에서 User 활성화 시키면 b1, b2가 같은 user를 가리키는 것을 알 수 있음.
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);


        assertTrue(b1 != null);
        assertTrue(b2 != null);



    }

    @Test
    @Order(2)
    @DisplayName("유저에서 Board여러개 받아오기.")
    public void UserManyBoardTest(){
        User user = userRepository.findById("aaa").orElse(null);
        System.out.println("user = " + user);
        System.out.println("user.getList = " + user.getList());
        assertTrue(user != null);

    }
}