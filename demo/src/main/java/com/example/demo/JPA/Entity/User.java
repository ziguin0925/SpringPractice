package com.example.demo.JPA.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


import java.util.Date;

@Entity
public class User {
    @Id @GeneratedValue
    private int id;
    private String name;
    private String password;
    private String email;

    private Date inDate;
    private Date upDate;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", inDate=" + inDate +
                ", upDate=" + upDate +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Date getInDate() {
        return inDate;
    }

    public Date getUpDate() {
        return upDate;
    }
}
