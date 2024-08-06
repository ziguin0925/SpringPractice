package com.example.demo.JPA.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "category", uniqueConstraints = @UniqueConstraint(columnNames = "category_code"))
@NoArgsConstructor
@Getter
@Setter
public class Category implements Serializable {

    @Id
    @Column(name = "category_code", length = 3)
    private String categoryCode;

    @Column(name = "category_name", length = 10)
    private String categoryName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_category_code", referencedColumnName = "category_code")
    private Category parentCategory;



    @Builder
    public Category(String categoryCode, String categoryName, Category parentCategory) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.parentCategory = parentCategory;
    }
}
