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
public class Brand{

    @Id
    @Column(name = "brand_code", length = 25)
    private String brandCode;

    @Column(name = "brand_name", length = 20)
    private String brandName;

    @Column(name = "brand_img", length = 500)
    private String brandImg;

    @Column(name = "brand_product_num")
    private int brandProductNum;


    @Builder
    public Brand(String brandCode, String brandName, String brandImg, int brandProductNum) {
        this.brandCode = brandCode;
        this.brandName = brandName;
        this.brandImg = brandImg;
        this.brandProductNum = brandProductNum;
    }
}