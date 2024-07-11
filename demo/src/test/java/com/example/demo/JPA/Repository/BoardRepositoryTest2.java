package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.Board;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTest2 {
    @Autowired
    private BoardRepository boardRepository;

    @BeforeEach
    void setUp() {
        for (int i = 0; i <= 100; i++) {
            Board board = new Board();
            board.setId((long)i);
            board.setTitle("title"+i);
            board.setContent("content"+i);
            board.setWriter("writer"+(i%5));
            board.setViewCnt((long)(Math.random()*100));
            board.setInDate(new Date());
            board.setUpDate(new Date());
            boardRepository.save(board);

        }
    }

    @Test
    @Order(1)
    public void countTest() {
        long count = boardRepository.count();
        assertEquals(100L, count);
    }

    @Test
    @Order(2)
    public void witerCount() {

        long count = boardRepository.countAllByWriter("writer1");
        assertEquals(20, count);

    }

    @Test
    @Order(3)
    public void findByWriterTest() {
        List<Board> boards = boardRepository.findByWriter("writer1");
        assertTrue(boards.size() ==20);
        boards.stream().forEach(System.out::println);
    }

    @Test
    @Order(4)
    public void deleteByWriterTest() {
        boardRepository.deleteByWriter("writer1");
        List<Board> boards = boardRepository.findByWriter("writer1");
        assertTrue(boards.size() ==0);
    }

}
