package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.Product;
import com.example.demo.JPA.Entity.QProduct;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDateTime;


public class ProductRepositoryImpl implements CustomProductRepository{

    private JPAQueryFactory queryFactory;

    public ProductRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }



    private BooleanExpression regDtsAfter(String searchDateType){

        LocalDateTime dateTime = LocalDateTime.now();

        if(StringUtils.equals("all", searchDateType) || searchDateType == null){
            return null;
        } else if(StringUtils.equals("1d", searchDateType)){
            dateTime = dateTime.minusDays(1);
        } else if(StringUtils.equals("1w", searchDateType)){
            dateTime = dateTime.minusWeeks(1);
        } else if(StringUtils.equals("1m", searchDateType)){
            dateTime = dateTime.minusMonths(1);
        } else if(StringUtils.equals("6m", searchDateType)){
            dateTime = dateTime.minusMonths(6);
        }

        return QProduct.product.productCreateTime.after(dateTime);
    }


    //페이지 기반, 커서 기반 나누기.

    @Override
    public Page<Product> getProductCursorPage(Product product, Pageable pageable) {

        return null;
    }

    @Override
    public Page<Product> getProductPagePage(Product product, Pageable pageable){

        return null;
    }



    /*
    @Override
    CustomProductRepository 에서 구현할 메서드 등록.
    기준 정렬에 따라서 가져오는거 하기.
    https://github.com/ziguin0925/webshop/blob/main/src/main/java/com/shop/repository/ItemRepositoryCustomImpl.java
    */

}
