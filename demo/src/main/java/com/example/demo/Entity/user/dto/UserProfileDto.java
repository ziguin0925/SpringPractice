package com.example.demo.Entity.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserProfileDto {
    private Long userId;
    private String username;
    private String email;
    private String imageUrL;
    private String nickname;
    private String phone;
    private Boolean infoAgreement;


}
