package com.example.demo.JPA.Entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(Long viewCnt) {
        this.viewCnt = viewCnt;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }
}
