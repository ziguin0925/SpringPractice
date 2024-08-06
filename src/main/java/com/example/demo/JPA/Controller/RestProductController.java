package com.example.demo.JPA.Controller;

import com.example.demo.JPA.Entity.Product;
import com.example.demo.JPA.Service.ProductService;
import com.example.demo.JPA.util.CursorRequest;
import com.example.demo.JPA.util.PageCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class RestProductController {

    @Autowired
    private ProductService productService;


    //       swagger-ui  http://localhost:8080/swagger-ui/index.html

    //https://blogshine.tistory.com/548
    //LAZY를 EAGER로 일단 바꿔줌(Product, Category 들어가보면 Joincolumn 뒤에 주석 처리 되어있음). 나중에는 DTO 설정해서 줄 정보만 주기.

    /*
    반환해주는 size가 2일 때(size는 1 이상)
    null이 nextCursorKey라면

    {
        "size": 2
    }로 해서 줘야함.

    Order By로 product_code(PK)가 desc로 정렬 되어있음. 문자열을 숫자로 변환했을 때 가장 큰 2개를 반환해줌.


    P006가 nextCursorKey라면
    {
        "key": "P006",
        "size": 2
    }
    P005, P004의 상품 정보를 반환해주고 P004를 nextCursorKey로 반환해줌.

    P004가 nextCursorKey 라면
    P003, P002의 상품 정보를 반환해주고 P002를 nextCursorKey로 반환해줌.
    문자열을 숫자로 반환했을 때 가장 작은 product_code가 nextCursorKey 가 된다면 반환 안하도록.
     */

    @GetMapping(value = {"/list"})
    public ResponseEntity<PageCursor<Product>> getProductList(
             CursorRequest cursorRequest
    ){

        /*
         *커서기반과 페이지 기반.
         * 정렬 기준 : 날짜, 가격, 판매량.
         * */
        System.out.println("Controllor : "+cursorRequest.key());

        return new ResponseEntity<>(productService.cursor(cursorRequest), HttpStatus.OK);
    }
}
