package com.example.demo.Entity.user.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserAdminPageRequestDto {
    private Integer page;
    private String keyword;
    private String condition;
    private String role;
}
