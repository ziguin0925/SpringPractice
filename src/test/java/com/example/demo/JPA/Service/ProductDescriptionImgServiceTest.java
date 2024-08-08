package com.example.demo.JPA.Service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.JPA.Entity.ProductDescription;
import com.example.demo.JPA.Entity.ProductDescriptionImg;
import com.example.demo.JPA.Repository.ProductDescriptionImgRepository;
import com.example.demo.JPA.Repository.ProductDescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
class ProductDescriptionImgServiceTest {

    private final ProductDescriptionImgRepository productDescriptionImgRepository;
    private final ProductDescriptionImgService productDescriptionImgService;
    private final ProductDescriptionRepository productDescriptionRepository;
    private final ProductDescriptionService productDescriptionService;


    //새로운 ProductDescription 이 생성될 때.
    //ProductDescriptionimg가 제대로 생성되는지 확인.
    @Test
    @Order(1)
    @DisplayName("저장되는지.")
    void testSave() throws IOException {

        // 저장 test할 multipartFile배열 생성
        MultipartFile[] productDescriptionImgs = new MultipartFile[]{
                createMockMultipartFile("desc1.jpg"),
                createMockMultipartFile("desc2.jpg")
        };

        MultipartFile[] productImgs = new MultipartFile[]{
                createMockMultipartFile("img1.jpg"),
                createMockMultipartFile("img2.jpg")
        };

        //임의의 productDescription을 생성하여 넣어줌
        ProductDescription productDescription = ProductDescription.builder()
                .productDescriptionId("aaaa")
                .productDescription("dkkdkk")
                .updateDate(LocalDateTime.now())
                .build();
        //productDescription을 save해줌.
        productDescriptionRepository.save(productDescription);


        //productDescription르 fk로 가지는 Imgs들 저장.
        productDescriptionImgService.save(productDescriptionImgs, productImgs, productDescription);

        //현재 4개 저장했으므로 4개가 맞는지 확인.
        assertEquals(4, productDescriptionImgRepository.findAll().size());

    }

    private MultipartFile createMockMultipartFile(String filename) throws IOException {
        return new MockMultipartFile(
                "file", // 파라미터 이름
                filename, // 원래 파일 이름
                "image/jpeg", // MIME 타입
                new ByteArrayInputStream("file content".getBytes()) // 파일 내용
        );
    }


    @Test
    @Order(2)
    @DisplayName("맵핑 되는지.")
    public void mapping (){
        ProductDescription p =productDescriptionService.findById("aaaa");

        List<ProductDescriptionImg> availFileList = productDescriptionImgService.findAllById(p);
        assertEquals(4, availFileList.size());

    }


}