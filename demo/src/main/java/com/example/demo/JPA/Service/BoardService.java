package com.example.demo.JPA.Service;

import com.example.demo.JPA.Entity.BoardMany;
import com.example.demo.JPA.Repository.BoardRepository;
import com.example.demo.JPA.Repository.BoardRepositoryMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {


    @Autowired
    private BoardRepositoryMany boardRepository;


    //모든 게시물 가져오기
    public List<BoardMany> getList(){
        return (List<BoardMany>) boardRepository.findAll();

    }

    //게시물 작성
    public BoardMany write(BoardMany board){
        return boardRepository.save(board);
    }

    //게시물 읽어오기


    public BoardMany read(Long id){
        return boardRepository.findById(id).orElse(null);
    }

    //게시물 수정
    public BoardMany modify(BoardMany newboard){
        BoardMany board = boardRepository.findById(newboard.getId()).orElse(null);

        if(board == null){
            return null;
        }
        board.setTitle(newboard.getTitle());
        board.setContent(newboard.getContent());

        return boardRepository.save(board);
    }

    public void remove(Long id){
        BoardMany board = boardRepository.findById(id).orElse(null);

        if(board != null){
            boardRepository.deleteById(id);
        }
    }

}

