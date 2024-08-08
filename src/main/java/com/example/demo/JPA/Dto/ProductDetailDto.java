package com.example.demo.JPA.Dto;

import java.util.List;

public class ProductDetailDto {
    private String productId;
    private String productName;
    private int price;
    private String productDescription;
    private String productRepImage;
    private List<String> categoryId;
    private List<String> categoryName;
//    private String productStatus;
    private int salesQuantity;
    private String brandName;

    private List<String> productImages;
    private List<String> descriptionImages;

    //review_content

    private float starRating;
    private int reviewCount;
    private int viewCount;

}
