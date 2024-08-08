package com.example.demo.JPA.Entity;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name="review")
@Entity
@Getter
@Setter
public class Review extends BaseTimeEntity {

    @Id
    @Column(name = "review_id")
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

/*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;
*/
    @Column(name="member_id")
    private String memberName;

    @Column(name="star_score")
    private float starScore;

    @Column(name = "content", length = 300)
    private String content;

    @Column(name="image")
    private String image;

    @Builder
    public Review(Product product, Long id, String memberName, float starScore, String content, String image) {
        this.product = product;
        this.id = id;
        this.memberName = memberName;
        this.starScore = starScore;
        this.content = content;
        this.image = image;
    }
}
