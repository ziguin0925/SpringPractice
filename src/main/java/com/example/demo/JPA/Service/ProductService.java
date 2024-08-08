package com.example.demo.JPA.Service;

import com.example.demo.JPA.Dto.ProductListDto;
import com.example.demo.JPA.Dto.ProductRegisterDto;
import com.example.demo.JPA.Entity.*;
import com.example.demo.JPA.Repository.*;
import com.example.demo.JPA.util.CursorRequest;
import com.example.demo.JPA.util.PageCursor;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    @Value(value = "${productRepImgLocation}")
    private String imgLocation;

    //쿼리dsl 사용 가능.
    private final ProductRepository productRepository;

    private final FileService fileService;

    //DTO
    public Product registerSave(ProductRegisterDto productRegisterDto
            , Category category
            , Brand brand
            , ProductDescription productDescription
            , MultipartFile repimg) throws IOException {

        String filename =repimg.getOriginalFilename();
        String fileCode = fileService.uploadFile(imgLocation, filename, repimg.getBytes());

        Product product = Product.Of(productRegisterDto, category, brand, productDescription, fileCode);


        //brandRepository - 브랜드 찾기.


        //


        productRepository.save(product);

        return product;
    }


    public void deleteById(String product_code) {
        productRepository.deleteById(product_code);
    }



    public Product findById(String id) {
        return productRepository.findById(id).orElse(null);
    }


    // 조회수 순, 별점 순 같은 경우는 100개만 표시.
    //트랜잭션 readOnly
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
                return productRepository.findAllByKeyword(PageRequest.of(page, pageLimit), keyword);

            }
        }catch (Exception e){
            throw e;
        }

    }


//트랜잭션 readOnly
    public PageCursor<ProductListDto> cursor(CursorRequest cursorRequest){

        List<Product> productList  = findAllBy(cursorRequest);

        List<ProductListDto> productListDtl =new ProductListDto().toDtoList(productList);

        return new PageCursor<>(cursorRequest.next(productListDtl.get(productListDtl.size()-1).getProductId()), productListDtl);

    }


    /*
    * 처음 요청이면 key가 null.
    * 두번 째 요청 부터 key가 null이 아님.
    * */
    private List<Product> findAllBy(CursorRequest cursorRequest) {
        if(cursorRequest.haskey()){
            return  productRepository.findByProductIdLessThanOrderByProductIdDesc(cursorRequest.key(), Limit.of(cursorRequest.size()));
        }
        return productRepository.findByOrderByProductIdDesc(Limit.of(cursorRequest.size()));
    }



}
