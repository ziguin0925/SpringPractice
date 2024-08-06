package com.example.demo.JPA.Service;

import com.example.demo.JPA.Dto.ProductListDto;
import com.example.demo.JPA.Entity.BoardMany;
import com.example.demo.JPA.Entity.Product;
import com.example.demo.JPA.Repository.ProductRepository;
import com.example.demo.JPA.Repository.ProductRepositoryImpl;
import com.example.demo.JPA.util.CursorRequest;
import com.example.demo.JPA.util.PageCursor;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    //쿼리dsl 사용 가능.
    private final ProductRepository productRepository;

    public void save(Product product) {

        productRepository.save(product);
    }



    public Product findById(String id) {
        return productRepository.findById(id).orElse(null);
    }


    // 조회수순, 별점순 같은 경우는 100개만 표시.

    public Page<Product> page(String keyword, Pageable pageable) {
        //페이지 기반
        //브랜드 페이지에서 사용
        int page = pageable.getPageNumber()-1;//page위치에 있는 값은 0부터 시작
        int pageLimit = 2;
        try{
            if(keyword == null || keyword.isEmpty()){
                //한 페이지당 2개의 글, 정렬기준은 ID기준으로 내림차순.
                return productRepository.findAll(PageRequest.of(page, pageLimit));
            }else {
                return productRepository.findAllbyKeyword(PageRequest.of(page, pageLimit), keyword);

            }
        }catch (Exception e){
            throw e;
        }

    }

/*
    public Page<Product> cursor(String condition ,Pageable pageable) {
        //커서 기반
        //전체 상품 검색, 정렬 에서, 카테고리
        return ;
    }
*/
    public PageCursor<Product> cursor(CursorRequest cursorRequest){
        System.out.println("findAllByStart");
        List<Product> productList  = findAllBy(cursorRequest);
        System.out.println("findAllByEnd");


        return new PageCursor<>(cursorRequest.next(productList.getLast().getProductCode()), productList);

    }

    private List<Product> findAllBy(CursorRequest cursorRequest) {
        if(cursorRequest.haskey()){
            return  productRepository.findByProductCodeLessThanOrderByProductCodeDesc(cursorRequest.key(), Limit.of(cursorRequest.size()));
        }
        return productRepository.findByOrderByProductCodeDesc(Limit.of(cursorRequest.size()));
    }

}
