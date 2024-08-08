package com.example.demo.JPA.Service;


import com.example.demo.JPA.Entity.Category;
import com.example.demo.JPA.Repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category findById(String categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }


}
