package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Dto.ProductListDto;
import com.example.demo.JPA.Entity.BoardMany;
import com.example.demo.JPA.Entity.Product;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>
        , CustomProductRepository
        , QuerydslPredicateExecutor<Product> {

    /*
    * select *
    * from product
    * where product_id > A000001000;
    *
    * */
/*
    @Query("SELECT * FROM product p WHERE p.product_id =:product_id LIMIT :size")
    public List<Product> findAll(@Param("product_id")String product_id, @Param("size")int size){

    }
*/

    @Query("SELECT b FROM Product b WHERE b.productName like concat('%', :keyword, '%')")
    Page<Product> findAllByKeyword(PageRequest of, @Param("keyword") String keyword);

    //product_id가 없을 때 (첫번 째 요청)
    List<Product> findByOrderByProductIdDesc(Limit limit);
    //product_id가 있을 때 (두번 째 이후 요청)
    List<Product> findByProductIdLessThanOrderByProductIdDesc(String product_id, Limit limit);

}
