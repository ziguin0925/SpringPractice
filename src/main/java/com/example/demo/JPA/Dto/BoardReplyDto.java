package com.example.demo.JPA.Dto;

import com.example.demo.JPA.Entity.BoardMany;
import com.example.demo.JPA.Entity.BoardReply;
import jakarta.persistence.GeneratedValue;
import lombok.*;
import org.springframework.data.domain.Page;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardReplyDto {

    private Long replyId;

    private Long boardId;

    private String userId;

    private String replyContent;

    private LocalDateTime replyDate;

    public Page<BoardReplyDto> toDtoList(Page<BoardReply> boardReplies) {
        Page<BoardReplyDto> boardDtoList = boardReplies.map(m -> BoardReplyDto.builder()
                .replyId(m.getReplyId())
                .replyContent(m.getReplyContent())
                .userId(m.getUser().getId())
                .boardId(m.getBoardmany().getId())
                .replyDate(m.getCreateDate())
                .build());
        return boardDtoList;
    }
    public List<BoardReplyDto> toDtoList(List<BoardReply> boardReplies) {
        List<BoardReplyDto> boardDtoList = boardReplies.stream().map(m -> BoardReplyDto.builder()
                .replyId(m.getReplyId())
                .replyContent(m.getReplyContent())
                .userId(m.getUser().getId())
                .boardId(m.getBoardmany().getId())
                .replyDate(m.getCreateDate())
                .build()).toList();

        return boardDtoList;
    }
}
