package com.example.demo.JPA.util;


import org.hibernate.dialect.pagination.NoopLimitHandler;

/*
인덱스 필수.
* 커서의 key는 중복키가 없어야 된다. - 유니크 해야된다.
* 중복키가 있으면 읽다가 끊길 수 있다.

처음 요청시에는 key가 없음 = default key = null
마지막 페이지는 필요없지만 마지막 데이터인지는 확인해야함.
* */
public record CursorRequest(String key, int size) {

    public Boolean haskey(){
        return key!=null;
    }

    public CursorRequest next(String key){
        return new CursorRequest(key, size);
    }
}
