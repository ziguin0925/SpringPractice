package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>
        , CustomProductRepository
        , QuerydslPredicateExecutor<Product> {

}
