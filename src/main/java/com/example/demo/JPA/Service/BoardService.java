package com.example.demo.JPA.Service;

import com.example.demo.JPA.Entity.BoardMany;
import com.example.demo.JPA.Entity.User;
import com.example.demo.JPA.Repository.BoardRepositoryMany;
import com.example.demo.JPA.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BoardService {


    @Autowired
    BoardRepositoryMany boardRepository;

    @Autowired
    private UserRepository userRepository;


    //모든 게시물 가져오기
    public Page<BoardMany> paging(Pageable pageable, String keyword){
        int page = pageable.getPageNumber()-1;//page위치에 있는 값은 0부터 시작
        int pageLimit = 2;

        if(keyword == null || keyword.isEmpty()){
            //한 페이지당 2개의 글, 정렬기준은 ID기준으로 내림차순.
            Page<BoardMany> boardPages = boardRepository.findAll(PageRequest.of(page, pageLimit));
            return boardPages;
        }else {
            Page<BoardMany> boardPages = boardRepository.findAllbyKeyword(PageRequest.of(page, pageLimit), keyword);
            return boardPages;
        }

        //DTO
        //Dto 만들면 바꿔주기.
//        Page<BoardManyDto> boardManyDto = boardPages.map(boardPage -> new BoardManyDto(boardPage))



    }


    //게시물 작성
    public BoardMany write(BoardMany board){
        board.setInDate(new Date(System.currentTimeMillis()));
        board.setUpDate(new Date(System.currentTimeMillis()));

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
    public User findUser(String id){

        return userRepository.findById(id).orElse(null);
    }

}

