package com.example.demo.Entity.user;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    TRADER("trader"),         // 트레이더
    INVESTOR("investor"),       // 투자자
    TRADER_ADMIN("trader-admin"),   // 트레이더 관리자
    INVESTOR_ADMIN("invester_admin");// 투자자 관리자

    private String name;

    Role(String name) {
        this.name = name;
    }
    
    @JsonValue
    public String getName(){
        return this.name;
    }
}