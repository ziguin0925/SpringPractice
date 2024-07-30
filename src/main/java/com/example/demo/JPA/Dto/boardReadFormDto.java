package com.example.demo.JPA.Dto;

import com.example.demo.JPA.Entity.BoardMany;
import com.example.demo.JPA.Entity.BoardReply;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
@NoArgsConstructor
public class boardReadFormDto {

    private BoardMany boardMany;
    private Page<BoardReplyDto> boardRepliesDto;

    public boardReadFormDto(BoardMany boardMany, Page<BoardReplyDto> boardRepliesDto) {
        this.boardMany = boardMany;
        this.boardRepliesDto = boardRepliesDto;
    }
}
