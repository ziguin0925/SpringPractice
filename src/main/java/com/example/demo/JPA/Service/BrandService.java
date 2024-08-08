package com.example.demo.JPA.Service;

import com.example.demo.JPA.Entity.Brand;
import com.example.demo.JPA.Repository.BrandRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    public Brand findById(String id) {
        return brandRepository.findById(id).orElse(null);
    }

}
