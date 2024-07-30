package com.example.demo.JPA.Service;


import com.example.demo.JPA.Dto.BoardReplyDto;
import com.example.demo.JPA.Dto.boardReadFormDto;
import com.example.demo.JPA.Entity.BoardMany;
import com.example.demo.JPA.Entity.BoardReply;
import com.example.demo.JPA.Entity.User;
import com.example.demo.JPA.Repository.BoardReplyRepository;
import com.example.demo.JPA.Repository.BoardRepositoryMany;
import com.example.demo.JPA.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardReplyService {

    private final BoardRepositoryMany boardRepositoryMany;

    private  final BoardReplyRepository boardReplyRepository;

    public boardReadFormDto getBoardWithReply(Long boardManyId, int page, int size) {
        BoardMany boardMany = boardRepositoryMany.findById(boardManyId).orElse(null);

        if (boardMany != null) {
            Pageable pageable = PageRequest.of(page, size);
            Page<BoardReply> boardReplies = boardReplyRepository.findByBoardmanyId(boardManyId, pageable);
            Page<BoardReplyDto> boardReplyDtos =new BoardReplyDto().toDtoList(boardReplies);
            return new boardReadFormDto(boardMany, boardReplyDtos);
        }
        return null;
    }

    public BoardReply save(BoardReplyDto boardReplyDto) {

        BoardMany boardMany = boardRepositoryMany.findById(boardReplyDto.getBoardId()).orElse(null);
        if (boardMany == null) {
            return null;
        }
        User user = boardMany.getUser();

        BoardReply boardReply = new BoardReply();
        boardReply.setReplyContent(boardReplyDto.getReplyContent());
        boardReply.setCreateDate(new Date(System.currentTimeMillis()));
        boardReply.setUser(user);
        boardReply.setBoardmany(boardMany);

        return boardReplyRepository.save(boardReply);
    }

    public void delete(BoardReply boardReply) {
        boardReplyRepository.delete(boardReply);
    }


    public Page<BoardReplyDto> findReplies(Pageable pageable,Long boardManyId) {

        Page<BoardReply> boardReplies = boardReplyRepository.findByBoardmanyId(boardManyId, pageable);

        return new BoardReplyDto().toDtoList(boardReplies);
    }
}
