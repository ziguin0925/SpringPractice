package com.example.demo.JPA.Repository;
/*
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    @Order(4)
    public void deleteTest(){
        boardRepository.deleteById(1L);
        Board board = boardRepository.findById(1L).orElse(null);
        assertTrue(board == null);

    }

    @Test
    @Order(3)
    public void upDateTest(){
        Board board = boardRepository.findById(1L).orElse(null);
        assertTrue(board!=null);

        board.setTitle("바뀐 로우 타이틀");
        boardRepository.save(board);
        Board board2 = boardRepository.findById(1L).orElse(null);
        assertTrue(board2.getTitle().equals(board.getTitle()));
        System.out.println(board2.getTitle());
        System.out.println(board.getTitle());
    }

    @Test
    @Order(2)
    public void selectTest(){

        Board board = boardRepository.findById(1L).orElse(null);
        System.out.println(board);
        assertTrue(board!=null);

    }

    @Test
    @Order(1)
    public void insertTest(){
        Board board = new Board();
        board.setId(1L);
        board.setTitle("가나다라마바사");
        board.setWriter("정룡우");
        board.setContent("예시 사항");
        board.setViewCnt(0L);
        board.setUpDate(new Date());
        board.setInDate(new Date());
        boardRepository.save(board);
    }
}*/