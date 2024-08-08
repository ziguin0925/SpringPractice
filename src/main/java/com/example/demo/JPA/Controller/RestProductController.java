package com.example.demo.JPA.Controller;

import com.example.demo.JPA.Dto.ProductListDto;
import com.example.demo.JPA.Dto.ProductRegisterDto;
import com.example.demo.JPA.Entity.Brand;
import com.example.demo.JPA.Entity.Category;
import com.example.demo.JPA.Entity.Product;
import com.example.demo.JPA.Entity.ProductDescription;
import com.example.demo.JPA.Repository.StockRepository;
import com.example.demo.JPA.Service.*;
import com.example.demo.JPA.util.CursorRequest;
import com.example.demo.JPA.util.PageCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class RestProductController {

    @Autowired
    ProductService productService;

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductDescriptionService productDescriptionService;

    @Autowired
    ProductDescriptionImgService productDescriptionImgService;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockService stockService;

    @PostMapping(value = {"/register"})
    public ResponseEntity<String> register(@RequestPart(value = "ProductRegisterDto")ProductRegisterDto productRegisterDto
            , @RequestPart(value = "RepImg")MultipartFile repImg
            , @RequestPart(value = "DescriptionImgs", required = false) MultipartFile[] desImgs
            , @RequestPart(value = "RepresentationImgs", required = false) MultipartFile[] represenImgs
            /*, Model model */) throws IOException {





        /*
         * product 필드
         * 상품 코드, 상품 이름 , 상품 대표 이미지, 상품 가격, 상품 화면 표시, 상품 등록 일시, 상품 변경일시, 판매량, 상품 관리자, 별점, 상품 상세 설명 id, 브랜드 코드, 카테고리 코드
         *
         * 받아올 값
         * 상품 코드, 상품 이름, 상품 대표 이미지, 상품 가격, 상품 관리자, 카테고리 코드, 브랜드 코드, 상품 상세 설명 id.
         * 상품 상세 설명 이미지, 상품 이미지.
         *
         *
         * 상품 상세 설명 id, 브랜드 코드, 카테고리 코드 미리 생성되어 있어야함.
         * */




        //받아온 brand 가 있는지 확인. - 없으면 등록 불가.
        Brand brand = brandService.findById(productRegisterDto.getBrandId());
        if (brand == null) {
            return new ResponseEntity<>(productRegisterDto.getName()+" 불가(brand없음)",HttpStatus.BAD_REQUEST);
        }

        //받아온 category 가 있는지 확인. - 없으면 불가.
        Category category = categoryService.findById(productRegisterDto.getCategoryId());
        if (category == null) {
            return new ResponseEntity<>(productRegisterDto.getName()+" 불가(카테고리 없음)",HttpStatus.BAD_REQUEST);
        }

        //사진 저장했는데 브랜드나 카테고리를 제대로 안받아 온거면 큰일, 맨 마지막.
        //product_description_id 가 있는지 확인 - 없으면 product_description과 product_description_img 둘다 생성해야함.
        ProductDescription productDescription = productDescriptionService.findById(productRegisterDto.getDescriptionName());
        if (productDescription == null) {
            try {
                //상세 설명 만들기.
                productDescription =productDescriptionService.save(productRegisterDto.getProductDescriptionContent()
                        , productRegisterDto.getDescriptionName()
                );

                //이미지 저장.
                productDescriptionImgService.save(desImgs
                        ,represenImgs
                        ,productDescription
                );
            }catch (Exception e) {
//                e.printStackTrace();
                return new ResponseEntity<>(productRegisterDto.getName()+" 불가(상세설명 등록 에러)",HttpStatus.CONFLICT);
            }
        }

        //나중에 회원 테이블 구현이 끝나면 회원 조회.
        Product product =productService.registerSave(productRegisterDto, category, brand, productDescription,repImg );

        stockService.save(product, productRegisterDto.getSize(), productRegisterDto.getColor(), productRegisterDto.getStock());

        return new ResponseEntity<>(productRegisterDto.getName()+" 완료",HttpStatus.OK);

    }


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
    public ResponseEntity<PageCursor<ProductListDto>> getProductList(
             CursorRequest cursorRequest
    ){

        /*
         *커서기반과 페이지 기반.
         * 정렬 기준 : 날짜, 가격, 판매량.
         * */
        // ProductDescriptionImg도 반환할 수 있도록.
        System.out.println("Controllor : "+cursorRequest.key());

        return new ResponseEntity<>(productService.cursor(cursorRequest), HttpStatus.OK);
    }

    @GetMapping(value = {"/find/{id}"})
    public ResponseEntity<Product> getProduct(@RequestBody String id){
        Product product = productService.findById(id);
        return new ResponseEntity<>( product ,HttpStatus.OK );
    }
}
