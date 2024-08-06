package com.example.demo.JPA.Entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "product_description", columnDefinition = "TEXT")
    private String productDescription;

    @Column(name = "update_date")
    private Date updateDate;


    public ProductDescription(String productDescriptionId, String productDescription, Date updateDate) {
        this.productDescriptionId = productDescriptionId;
        this.productDescription = productDescription;
        this.updateDate = updateDate;
    }
}
