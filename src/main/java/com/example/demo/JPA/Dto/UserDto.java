package com.example.demo.JPA.Dto;


import lombok.Getter;

import java.sql.Date;

@Getter
public class UserDto {
    private String id;

    private String name;

    private String password;
    private String email;

    private Date birth;
    private String sns;
}
