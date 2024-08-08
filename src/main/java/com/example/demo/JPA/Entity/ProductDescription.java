package com.example.demo.JPA.Entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "product_description")
@NoArgsConstructor
@Getter
@Setter
public class ProductDescription {

    @Id
    @Column(name = "product_description_id", length = 25)
    private String productDescriptionId;

    @Column(name = "description", columnDefinition = "TEXT")
    private String productDescription;

    @Column(name = "modify_datetime")
    private LocalDateTime updateDate;


    //productDescription의 중복없이 설정하는 함수 생성해야함. UUID


    @Builder
    public ProductDescription(String productDescriptionId, String productDescription, LocalDateTime updateDate) {
        this.productDescriptionId = productDescriptionId;
        this.productDescription = productDescription;
        this.updateDate = updateDate;
    }
}
