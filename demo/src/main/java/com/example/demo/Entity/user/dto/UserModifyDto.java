package com.example.demo.Entity.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
/*
     회원 정보 수정 시 사용할 Dto
    data : password, imageUrl, phone, email, nickName, infoAgreement, infoReceive


 */

@Data
@ToString
@AllArgsConstructor
public class UserModifyDto {

    private String nickname;

    private String password;

    // imageDto의 정보로 Service에서 유효성 검사 진행 후 presigned url 요청, 기존의 s3에 저장된 사진 제거.
    private ImageDto imageDto;

    private String phone;

    private String email;

    private Boolean infoAgreement;

}
