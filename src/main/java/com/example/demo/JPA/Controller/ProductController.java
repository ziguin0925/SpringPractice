package com.example.demo.JPA.Controller;

import com.example.demo.JPA.Dto.ReplyDeleteDto;
import com.example.demo.JPA.Entity.Product;
import com.example.demo.JPA.Entity.ProductDescription;
import com.example.demo.JPA.Repository.ProductRepository;
import com.example.demo.JPA.Service.ProductService;
import com.example.demo.JPA.util.CursorRequest;
import com.example.demo.JPA.util.PageCursor;
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


    //GET으로 등록 화면 내어주고,
    //RESTController 쪽에서 등록 완료 표시 보내주기.
    //이거 GET으로 고치기.
//    @PostMapping(value ={"/register"})
//    @ResponseBody
//    public ResponseEntity<String> registerProduct(/*@RequestBody ReplyDeleteDto replyDeleteDto*/){
//        /*
//        * product 필드
//        * 상품 코드, 상품 이름 , 상품 대표 이미지, 상품 가격, 상품 화면 표시, 상품 등록 일시, 상품 변경일시, 판매량, 상품 관리자, 별점, 상품 상세 설명 id, 브랜드 코드, 카테고리 코드
//        *
//        * 받아올 값
//        * 상품 이름, 상품 대표 이미지, 상품 가격, 상품 관리자, 카테고리 코드, 브랜드 코드, 상품 상세 설명 id.
//        * 상품 상세  설명 id, 브랜드 코드, 카테고리 코드 미리 생성되어 있어야함.
//        * */
//
//
//        productService.save(product);
//
//        return new ResponseEntity<>(product.getProductName()+" 완료",HttpStatus.OK);
//    }
//


    @GetMapping(value = {"/detail/{id}"})
    public String productDetail(@PathVariable String id, Model model){
        Product product =productService.findById(id);

        if(product == null) return "index";

        model.addAttribute("product", product);
        return  "product/deteilpage";
    }
}
