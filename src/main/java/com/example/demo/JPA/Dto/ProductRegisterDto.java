package com.example.demo.JPA.Dto;

import com.example.demo.JPA.Entity.Product;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


//나중에 jakarta validation으로 유효성 검사해주기.
@Getter
public class ProductRegisterDto {

    //중복되는 상품 ID 가 있는지 확인.(등록자가 상품ID 등록?)
    //실제 상품ID를 받고, 실제 상품 ID 뒤에 번호 등 추가하기.
    private String productId;

    private String name;

    //해당 브랜드가 있는지 확인.
    private String BrandId;

    private String descriptionName;
    //목록에 나타낼 대표 사진 이외 모든 상세 설명 재사용 할지 여부.
    private String productDescriptionContent;//기존의 product_description_id을 사용하지 않는다면 받아오기.

    private String repImg;



    private String categoryId;

    private int price;
    private String managerName;

    //재고- 사이즈, 컬러, 재고 수량 받기
    private List<String> size= new ArrayList<>();
    private List<String> color= new ArrayList<>();
    private List<Integer> stock= new ArrayList<>();


    @Builder
    public ProductRegisterDto(String productId, String name, String brandId, String descriptionName, String productDescriptionContent, String repImg, String categoryId, int price, String managerName, List<String> size, List<String> color, List<Integer> stock) {
        this.productId = productId;
        this.name = name;
        BrandId = brandId;
        this.descriptionName = descriptionName;
        this.productDescriptionContent = productDescriptionContent;
        this.repImg = repImg;
        this.categoryId = categoryId;
        this.price = price;
        this.managerName = managerName;
        this.size = size;
        this.color = color;
        this.stock = stock;
    }
}
