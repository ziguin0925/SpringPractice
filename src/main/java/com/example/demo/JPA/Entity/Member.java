package com.example.demo.JPA.Entity;


import jakarta.persistence.*;

@Entity
public class Member {
    @Id
    @Column(name="member_id")
    private long member_id;




    @OneToOne(mappedBy = "member")
//    @JoinColumn(name="cart_id")
    private Cart cart;

    private String password;

    private String name;

    private String email;


    @Override
    public String toString() {
        return "Member{" +
                "member_id=" + member_id +
                ", cart=" + cart +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setMember_id(long member_id) {
        this.member_id = member_id;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMember_id() {
        return member_id;
    }

    public Cart getCart() {
        return cart;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
