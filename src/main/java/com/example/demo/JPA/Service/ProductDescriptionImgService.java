package com.example.demo.JPA.Service;


import com.example.demo.JPA.Entity.ProductDescription;
import com.example.demo.JPA.Entity.ProductDescriptionImg;
import com.example.demo.JPA.Repository.ProductDescriptionImgRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductDescriptionImgService {

    @Value("${productImgLocation}")
    private String imgLocation;

    private final ProductDescriptionImgRepository productDescriptionImgRepository;
    private final FileService fileService;

    public void save(MultipartFile[] productDescriptionImgs, MultipartFile[] productImgs, ProductDescription productDescription) throws IOException {

        byte i =1;

        for(MultipartFile file : productDescriptionImgs){

            String filename = file.getOriginalFilename();
            String fileCode = fileService.uploadFile(imgLocation, filename, file.getBytes());

            ProductDescriptionImg productDescriptionImg
                    = ProductDescriptionImg.builder()
                    .productDescription(productDescription)
                    .name(filename)
                    .path(imgLocation+fileCode)
                    .orderNum(i++)
                    .size(file.getSize())
                    .kindOf(ProductDescriptionImg.DESCRIPTION)
                    .isUsed(ProductDescriptionImg.DEFAULT_USE)
                    .build();
            productDescriptionImgRepository.save(productDescriptionImg);
        }

        i=1;

        for(MultipartFile file : productImgs){

            String filename = file.getOriginalFilename();
            String fileCode = fileService.uploadFile(imgLocation, filename, file.getBytes());

            ProductDescriptionImg productDescriptionImg
                    = ProductDescriptionImg.builder()
                    .productDescription(productDescription)
                    .name(filename)
                    .path(imgLocation+fileCode)
                    .orderNum(i++)
                    .size(file.getSize())
                    .kindOf(ProductDescriptionImg.REPRESENTATION)
                    .isUsed(ProductDescriptionImg.DEFAULT_USE)
                    .build();
            productDescriptionImgRepository.save(productDescriptionImg);
        }

    }

    //얘는 product_description_id으로 찾아야함.
    public List<ProductDescriptionImg> findAllById(ProductDescription productDescription) {

        return productDescriptionImgRepository
                .findAllByProductDescriptionAndIsUsedOrderByOrderNum(productDescription, ProductDescriptionImg.DEFAULT_USE);
    }

}
