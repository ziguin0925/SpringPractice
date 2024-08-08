package com.example.demo.JPA.Service;

import com.example.demo.JPA.Entity.Product;
import com.example.demo.JPA.Repository.BrandRepository;
import com.example.demo.JPA.Repository.CategoryRepository;
import com.example.demo.JPA.Repository.ProductDescriptionRepository;
import com.example.demo.JPA.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
class ProductServiceTest {

    private final ProductService productService;
    private final ProductDescriptionRepository productDescriptionRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository  brandRepository;
    @Autowired
    private ProductRepository productRepository;


    @Test
    @Order(1)
    @DisplayName("상품 id 를 통한 상품 불러오기.")
    void getProducts(){

        Product product = productService.findById("P001");
        assertEquals("나이키 남성 빨강 티셔츠", product.getProductName());
    }

/*
    @Test
    @Order(2)
    @DisplayName("상품 저장")
    void saveProduct(){
        Product product = Product.builder()
                .productId("aff")
                .productDescription(productDescriptionRepository.findById("ADIDAS0000001").orElse(null))
                .category(categoryRepository.findById("C08").orElse(null))
                .brand(brandRepository.findById("A00000000003").orElse(null))
                .productName("아디다스 여성 블라우스")
                .repImg("/img/ADIDAS/rep/image3.jpg")
                .price(12345)
                .isDisplayed("Y")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .salesQuantity(255)
                .registerManager("manager3")
                .starRating(2.5F)
                .viewCount(0)
                .reviewCount(0)
                .build();

        productService.save(product);
        Product savedProduct = productService.findById("aff");
        assertTrue(savedProduct.getProductName().equals("아디다스 여성 블라우스"));

        productService.deleteById("aff");

        assertTrue(productRepository.findById("aff").isEmpty());

    }
*/

}