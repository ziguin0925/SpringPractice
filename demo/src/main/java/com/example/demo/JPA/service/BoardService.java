package com.example.demo.JPA.service;

import com.example.demo.Entity.board.Board;
import com.example.demo.JPA.Repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public String isIdEven(Board board){
        if(board.getId()%2==0){
            return "Even";
        }
        return "Odd";
    }

}
