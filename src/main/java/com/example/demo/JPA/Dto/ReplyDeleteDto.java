package com.example.demo.JPA.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyDeleteDto {
    private Long replyId;
    private Long BoardId;
    private String userId;
}
