package com.example.demo.JPA.Dto;

import com.example.demo.JPA.Entity.BoardReply;
import com.example.demo.JPA.Entity.Product;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductListDto {


    private String productId;

    private String productName;

    private int price;

    private String brand;

    private static ModelMapper modelMapper = new ModelMapper();

    @Builder
    public ProductListDto(String productId, String productName, int price, String brand) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.brand = brand;
    }


    public static ProductListDto of(Product product) {
        return modelMapper.map(product, ProductListDto.class);
    }

    public List<ProductListDto> toDtoList(List<Product> productList) {
        List<ProductListDto> productDtoList = productList.stream().map(m -> ProductListDto.builder()
                .productId(m.getProductId())
                .productName(m.getProductName())
                .price(m.getPrice())
                .brand(m.getBrand().getBrandName())
                .build()).toList();

        return productDtoList;
    }

}
