package com.example.demo.JPA.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class User {


    @Id
    @Column(name="user_id")
    private String id;

    //EAGER - 두엔티티의 정보를 동시에 가져오는것.
    //LAZY - 따로 가져오는것. 나중에 getList(). default로 설정 되어있음.
    //LAZY를 사용하기 위해서는 해당 메서드를 이용하는 클래스에 @Transactional을 사용해야됨.
    //또한 findById등을 통해 들고와도 user의 정보만 들고오므로
    //Board의 정보도 얻고 싶다면 get해당 객체 얻기 메서드 를 실행 하여야 한다.
    //ManyToOneTest코드 보기


    //유저 하나에 여러 Board
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<BoardMany> list = new ArrayList<BoardMany>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<BoardReply> replyList = new ArrayList<BoardReply>();

    private String name;

    private String password;

    private String email;

    private Date inDate;

    private Date birth;

    private Date upDate;

    private String sns;


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", list=" + list +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", inDate=" + inDate +
                ", birth=" + birth +
                ", upDate=" + upDate +
                ", sns='" + sns + '\'' +
                '}';
    }
}
