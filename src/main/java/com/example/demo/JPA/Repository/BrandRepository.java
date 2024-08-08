package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, String> {
}
