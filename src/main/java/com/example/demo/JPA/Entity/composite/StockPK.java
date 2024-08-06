package com.example.demo.JPA.Entity.composite;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class StockPK {

    @Column(name= "color", length = 10)
    private String color;


    @Column(name= "size", length = 5)
    private String size;

    private String product_code;

    @Builder
    public StockPK(String color, String size, String product_code) {
        this.color = color;
        this.size = size;
        this.product_code = product_code;
    }
}
