package com.example.demo.JPA.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    // 제품 상태를 isDisplayed가 아니라 enum으로 상태를 나타낼지 생각.

    @Id
    @Column(name = "product_code", length = 25, nullable = false)
    private String productCode;

    @ManyToOne(fetch = FetchType.EAGER)//LAZY
    @JoinColumn(name = "product_description_id", referencedColumnName = "product_description_id")
    private ProductDescription productDescription;

    @ManyToOne(fetch = FetchType.EAGER)//LAZY
    @JoinColumn(name = "category_code", referencedColumnName = "category_code")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)//LAZY
    @JoinColumn(name = "brand_code", referencedColumnName = "brand_code")
    private Brand brand;

    @Column(name = "product_name", length = 25)
    private String productName;

    @Column(name = "rep_img", length = 500)
    private String repImg;

    @Column(name = "product_price")
    private int productPrice;

    @Column(name = "is_displayed", length = 1)
    private String isDisplayed;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "product_create_time")
    private LocalDateTime productCreateTime;

    @Column(name = "updated_time", length = 19)
    private String updatedTime;

    @Column(name = "sales_quantity")
    private long salesQuantity;

    @Column(name = "register_manager", length = 20)
    private String registerManager;

    @Column(name = "star_rating")
    private float starRating;



    @Builder
    public Product(String productCode, ProductDescription productDescription, Category category, Brand brand,
                   String productName, String repImg, int productPrice, String isDisplayed, LocalDateTime productCreateTime,
                   String updatedTime, long salesQuantity, String registerManager, float starRating) {
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.category = category;
        this.brand = brand;
        this.productName = productName;
        this.repImg = repImg;
        this.productPrice = productPrice;
        this.isDisplayed = isDisplayed;
        this.productCreateTime = productCreateTime;
        this.updatedTime = updatedTime;
        this.salesQuantity = salesQuantity;
        this.registerManager = registerManager;
        this.starRating = starRating;
    }
}