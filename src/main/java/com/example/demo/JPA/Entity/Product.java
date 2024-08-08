package com.example.demo.JPA.Entity;

import com.example.demo.JPA.Dto.ProductRegisterDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product extends BaseTimeEntity {

    public static String DEFAULT_DISPLAY = "Y";
    // 제품 상태를 isDisplayed가 아니라 enum으로 상태를 나타낼지 생각.
    //상태 넣자. isDisplayed 를 빼고, 품절, 판매 중, 판매 금지. 이런식으로.

    @Id
    @Column(name = "product_id", length = 25, nullable = false)
    private String productId;

    @ManyToOne(fetch = FetchType.EAGER)//LAZY
    @JoinColumn(name = "product_description_id", referencedColumnName = "product_description_id")
    private ProductDescription productDescription;

    @ManyToOne(fetch = FetchType.EAGER)//LAZY
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)//LAZY
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brand brand;

    @Column(name = "name", length = 25)
    private String productName;

    @Column(name = "rep_img", length = 500)
    private String repImg;

    @Column(name = "price")
    private int price;

    @Column(name = "register_manager", length = 20)
    private String registerManager;

    @Column(name = "is_displayed", length = 1)
    @ColumnDefault("'Y'")
    private String isDisplayed;


    @Column(name = "sales_quantity")
    @ColumnDefault("0")
    private long salesQuantity;

    @Column(name = "star_rating")
    @ColumnDefault("0")
    private float starRating;

    @Column(name ="view_count", nullable = false)
    @ColumnDefault("0")
    private int viewCount;

    @Column(name ="review_count",nullable = false)
    @ColumnDefault("0")
    private int reviewCount;



    @Builder
    public Product(String productId, ProductDescription productDescription
            , Category category, Brand brand, String productName
            , String repImg, int price, String isDisplayed
            , long salesQuantity, String registerManager, float starRating
            , int viewCount, int reviewCount) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.category = category;
        this.brand = brand;
        this.productName = productName;
        this.repImg = repImg;
        this.price = price;
        this.isDisplayed = isDisplayed;
        this.salesQuantity = salesQuantity;
        this.registerManager = registerManager;
        this.starRating = starRating;
        this.viewCount = viewCount;
        this.reviewCount = reviewCount;
    }

    public static Product Of(ProductRegisterDto productRegisterDto
            ,Category category
            ,Brand brand
            ,ProductDescription productDescription
            ,String fileURL
                             ){
        Product registerProduct = Product.builder()
                .productId(productRegisterDto.getProductId())
                .productDescription(productDescription)
                .category(category)
                .brand(brand)
                .productName(productRegisterDto.getName())
                .repImg(fileURL)
                .price(productRegisterDto.getPrice())
                .registerManager(productRegisterDto.getManagerName())
                .isDisplayed(DEFAULT_DISPLAY)
                .build();

        return registerProduct;
    }

    private static ModelMapper modelMapper = new ModelMapper();
    //ProductRegisterDto 객체로 하기.

}