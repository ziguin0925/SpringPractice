package com.example.demo.JPA.Service;

import com.example.demo.JPA.Entity.ProductDescription;
import com.example.demo.JPA.Repository.ProductDescriptionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductDescriptionService{

    private final ProductDescriptionRepository productDescriptionRepository;

    public ProductDescription findById(String productDescriptionId){
        return productDescriptionRepository.findById(productDescriptionId).orElse(null);
    }

    //이거 고치기.
    public ProductDescription save(String productDescriptionContents, String code){

        ProductDescription productDescription
                = ProductDescription.builder()
                .productDescriptionId(code)
                .productDescription(productDescriptionContents)
                .build();

        productDescriptionRepository.save(productDescription);

        return productDescription;
    }

}
