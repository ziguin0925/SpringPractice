package com.example.demo.diffrentdomain.test;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.Entity.board.Board;
import com.example.demo.JPA.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTest2 {

    @Autowired
    private BoardService boardService;



    @Test
    @DisplayName("Mock안하고")
    void test1(){

        Board board = new Board();
        board.setId(3L);

        String a = boardService.isIdEven(board);

        assertThat(a).isEqualTo("Even");

    }
}
