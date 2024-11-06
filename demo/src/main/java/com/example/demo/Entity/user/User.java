package com.example.demo.Entity.user;

import com.example.demo.Entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; // 회원 ID, 기본 키로 자동 증가됨

    private String username; // 사용자 이름 (로그인 아이디로 사용될 수 있음)

    private String nickname; // 사용자 닉네임 (표시 이름)

    private String email; // 이메일 주소

    private String password; // 비밀번호 (암호화 필요)

    @Column(length = 1000)
    private String imageUrL; // 프로필 이미지 URL

    private String phone; // 전화번호

    private String birthDate; // 생년월일 (YYYYMMDD 형식)

    private String ipAddress; // 마지막 로그인 시 사용한 IP 주소

    private Boolean infoAgreement; // 정보 제공 동의 여부 (true: 동의, false: 비동의)

    private LocalDate joinDate; // 가입일자

    private LocalDate withdrawalDate; // 탈퇴일자 (탈퇴한 경우에만 값이 있음)

    @Enumerated(EnumType.STRING)
    private UserState userState; // 회원 상태

    private Boolean withdrawalStatus; // 탈퇴 여부

    @Enumerated(EnumType.STRING)
    private Role role; // 회원 등급 또는 역할
}
