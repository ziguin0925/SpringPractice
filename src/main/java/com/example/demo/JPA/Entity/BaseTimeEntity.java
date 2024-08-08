package com.example.demo.JPA.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
//JPA Entity에 이벤트가 발생할 때 콜백을 처리하고 코드를 실행하는 방법
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
@Getter
@Setter
public abstract class BaseTimeEntity {

    //생성 될 때 자동 생성.
    @CreatedDate
    @Column(name ="create_datetime",updatable = false)
    private LocalDateTime createDateTime;


    //조회 후 저장시에 자동 생성
    @LastModifiedDate
    @Column(name="modify_datetime")
    private LocalDateTime modifyDatetime;

}