package com.example.demo.JPA.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class BoardMany {

    //한유저가 많은 게시판을 작성한 경우.

    @Id
    @GeneratedValue
    private Long id;

    private String title;


    //여러 Board에 유저는 한명
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToMany(mappedBy = "boardmany", fetch = FetchType.LAZY , cascade =CascadeType.ALL, orphanRemoval=true)
    private List<BoardReply> replyList;

    private String content;


    private Long viewCnt;

    @Temporal(value = TemporalType.DATE)
    private Date inDate;
    @Temporal(value = TemporalType.DATE)
    private Date upDate;



    //user 와 ManyBoard 에서 둘다 toString을 호출하면 스택 넘침.
    //Board tostring 시에 일단 user 빼주기
    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
//                ", user=" + user +
                ", content='" + content + '\'' +
                ", viewCnt=" + viewCnt +
                ", inDate=" + inDate +
                ", upDate=" + upDate +
                '}';
    }


}
