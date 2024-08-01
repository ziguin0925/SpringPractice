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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardReplyService {

    private final BoardRepositoryMany boardRepositoryMany;

    private  final BoardReplyRepository boardReplyRepository;
    private final UserRepository userRepository;

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

    public boardReadFormDto getBoardWithReply(Long boardManyId){
        BoardMany boardMany = boardRepositoryMany.findById(boardManyId).orElse(null);
        if (boardMany != null) {
            List<BoardReply> boardReplies = boardReplyRepository.findByBoardmanyId(boardManyId);
            List<BoardReplyDto> boardReplyDtos =new BoardReplyDto().toDtoList(boardReplies);
            return new boardReadFormDto(boardMany, boardReplyDtos);
        }
        return null;
    }

    public List<BoardReplyDto> getReplies(Long boardManyId){
        List<BoardReply> boardReplies = boardReplyRepository.findByBoardmanyId(boardManyId);
        List<BoardReplyDto> boardReplyDtos =new BoardReplyDto().toDtoList(boardReplies);
        return boardReplyDtos;
    }


    public BoardReply save ( BoardReplyDto boardReplyDto ) {

        BoardMany boardMany = boardRepositoryMany.findById(boardReplyDto.getBoardId()).orElse(null);
        if (boardMany == null) {
            return null;
        }
        User user = userRepository.findById(boardReplyDto.getUserId()).orElse(null);
        if(user==null){
            return null;
        }
        //이 부분 함수로 entity함수로 처리하기
        BoardReply boardReply = new BoardReply();
        boardReply.setReplyContent(boardReplyDto.getReplyContent());
        boardReply.setCreateDate(LocalDateTime.now());
        boardReply.setUser(user);
        boardReply.setBoardmany(boardMany);

        return boardReplyRepository.save(boardReply);
    }

    public void delete(Long replyId, String userId ) {


        BoardReply boardReply = boardReplyRepository.findById(replyId).orElse(null);
        if (boardReply != null) {
            if(boardReply.getUser().getId().equals(userId)){
                boardReplyRepository.delete(boardReply);
            }

        }
    }


    public Page<BoardReplyDto> findReplies(Pageable pageable,Long boardManyId) {

        Page<BoardReply> boardReplies = boardReplyRepository.findByBoardmanyId(boardManyId, pageable);

        return new BoardReplyDto().toDtoList(boardReplies);
    }
}
