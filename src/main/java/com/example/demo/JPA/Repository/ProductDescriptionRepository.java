package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.BoardMany;
import com.example.demo.JPA.Entity.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDescriptionRepository extends JpaRepository<ProductDescription, String> {
}
