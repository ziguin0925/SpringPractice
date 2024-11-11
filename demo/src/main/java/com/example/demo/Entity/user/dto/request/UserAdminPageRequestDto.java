package com.example.demo.Entity.user.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
public class UserAdminPageRequestDto {
    public static final int size = 20;

    private Integer page;
    private String keyword;
    private String condition;
    private String role;
}
