package com.example.demo.JPA.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class BoardReply {
    @Id @GeneratedValue
    @Column(name= "reply_id")
    private Long replyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borad_many")
    private BoardMany boardmany;


    @ManyToOne
    @JoinColumn(name="user", nullable=false)
    private User user;

    private String replyContent;

    @CreatedDate
    private Date createDate;

}
