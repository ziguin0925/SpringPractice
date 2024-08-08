package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.ProductDescription;
import com.example.demo.JPA.Entity.ProductDescriptionImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDescriptionImgRepository extends JpaRepository<ProductDescriptionImg,Long> {

    List<ProductDescriptionImg> findAllByProductDescriptionAndIsUsedOrderByOrderNum(ProductDescription productDescription, String used);
}
