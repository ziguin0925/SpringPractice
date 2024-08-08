package com.example.demo.JPA.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "brand")
@Getter
@Setter
@NoArgsConstructor
public class Brand extends BaseTimeEntity{

    @Id
    @Column(name = "brand_id", length = 25)
    private String brandId;

    @Column(name = "name", length = 20)
    private String brandName;

    @Column(name = "img", length = 500)
    private String brandImg;

    @Column(name = "product_num")
    private int brandProductNum;


    @Builder
    public Brand(String brandId, String brandName, String brandImg, int brandProductNum) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandImg = brandImg;
        this.brandProductNum = brandProductNum;

    }
}