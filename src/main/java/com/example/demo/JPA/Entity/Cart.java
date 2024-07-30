package com.example.demo.JPA.Entity;

import jakarta.persistence.*;

@Entity
public class Cart {

    @Id
    @Column(name = "cart_id")
    private Long id;

    //ManyToMany로 한다면
    //Cart에서 Member를 가지고 있어야됨(FK가짐)
    //Cart는 Member 한명밖에 못고름.
    //Member는 Cart 여러개 가능.
    @OneToOne
    @JoinColumn(name ="member_id", nullable = false)//fk
    //@Column(name="member_id")과 1:1 연결이 됨.
    private Member member;


    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", member=" + member +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }
}
