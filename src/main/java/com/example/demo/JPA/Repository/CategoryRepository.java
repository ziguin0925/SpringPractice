package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
