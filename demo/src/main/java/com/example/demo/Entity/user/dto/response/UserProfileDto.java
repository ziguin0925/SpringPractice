package com.example.demo.Entity.user.dto.response;


import com.example.demo.Entity.user.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserProfileDto{

    private String userId;

    private String userName;

    private String email;

    private String imageUrl;

    private String phone;

    private Boolean infoAgreement;

    private Role role;
}
