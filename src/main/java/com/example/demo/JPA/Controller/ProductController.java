package com.example.demo.JPA.Controller;

import com.example.demo.JPA.Dto.ReplyDeleteDto;
import com.example.demo.JPA.Entity.Product;
import com.example.demo.JPA.Repository.ProductRepository;
import com.example.demo.JPA.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping(value ={"/register"})
    @ResponseBody
    public ResponseEntity<String> registerProduct(/*@RequestBody ReplyDeleteDto replyDeleteDto*/){
        /*
        * product 필드
        * 상품 코드, 상품 이름 , 상품 대표 이미지, 상품 가격, 상품 화면 표시, 상품 등록 일시, 상품 변경일시, 판매량, 상품 관리자, 별점, 상품 상세 설명 id, 브랜드 코드, 카테고리 코드
        *
        * 받아올 값
        * 상품 이름, 상품 대표 이미지, 상품 가격, 상품 관리자, 카테고리 코드, 브랜드 코드, 상품 상세 설명 id.
        * 상품 상세  설명 id, 브랜드 코드, 카테고리 코드 미리 생성되어 있어야함.
        * */
        return new ResponseEntity<String>("제품 등록 성공.",HttpStatus.OK);
    }

    @GetMapping(value = {"/list"})
    @ResponseBody
    public ResponseEntity<Product> getProductList(){
        /*
        *커서기반과 페이지 기반.
        * 정렬 기준 : 날짜, 가격, 판매량.
        * */
        return new ResponseEntity<>(new Product(), HttpStatus.OK);
    }

    @GetMapping(value = {"/detail/{id}"})
    public String productDetail(@PathVariable Long id, Model model){



        return  "product/deteilpage";
    }



}
