package com.example.demo.JPA.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="product_description_img")
@ToString
public class ProductDescriptionImg extends BaseTimeEntity{

    public static String DEFAULT_USE ="Y";
    public static String DESCRIPTION = "DES";
    public static String REPRESENTATION = "REP";

    @Id
    @Column(name = "product_description_img_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productDescriptionImgId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="product_description_id")
    private ProductDescription productDescription;

    @Column(name ="name", length = 50)
    private String name;

    @Column(name = "order_num")
    private byte orderNum;

    @Column(name ="path", length = 500)
    private String path;

    @Column(name="is_used", length = 1)
    private String isUsed;

    @Column(name ="kind_of", length = 10)
    private String kindOf;

    @Column(name="size")
    private Long size;

    @Builder
    public ProductDescriptionImg( ProductDescription productDescription, String name, byte orderNum, String path, String isUsed, String kindOf, Long size) {
        this.productDescription = productDescription;
        this.name = name;
        this.orderNum = orderNum;
        this.path = path;
        this.isUsed = isUsed;
        this.kindOf = kindOf;
        this.size = size;
    }
}
