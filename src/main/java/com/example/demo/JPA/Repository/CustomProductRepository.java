package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomProductRepository {

    Page<Product> getProductCursorPage(Product product, Pageable pageable);

    Page<Product> getProductPagePage(Product product, Pageable pageable);
}
