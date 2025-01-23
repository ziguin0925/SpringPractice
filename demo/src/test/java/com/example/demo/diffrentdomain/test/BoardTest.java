package com.example.demo.diffrentdomain.test;


import static org.mockito.Mockito.when;

import com.example.demo.Entity.board.Board;
import com.example.demo.JPA.Repository.board.BoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.DurationFormat;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BoardTest {

    @Spy
    private BoardRepository boardRepository;



    @Test
    @DisplayName("다른 도메인 application context test")
    void context() {
        Board board = new Board();
        board.setId(2L);

        boardRepository.save(board);
    }

    @Test
    @DisplayName("다른 도메인 application context test ")
    void context2() {

        Board board = new Board();
        board.setId(1L);
        boardRepository.save(board);

        Board board2 = new Board();
        board2.setId(2L);
        boardRepository.save(board2);
    }

}
