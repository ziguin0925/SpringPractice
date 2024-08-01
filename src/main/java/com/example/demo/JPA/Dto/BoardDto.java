package com.example.demo.JPA.Dto;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public class BoardDto {

    private int id;

    private String title;

    private String content;

    private String writer_id;

}
