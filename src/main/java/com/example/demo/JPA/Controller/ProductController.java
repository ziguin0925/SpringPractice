package com.example.demo.JPA.Controller;

import com.example.demo.JPA.Entity.Product;
import com.example.demo.JPA.Service.ProductService;
import lombok.RequiredArgsConstructor;
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
    @GetMapping(value ={"/register"})
    public String registerProduct(){

        return "product/registerForm";
    }



    @GetMapping(value = {"/detail/{id}"})
    public String productDetail(@PathVariable String id, Model model){
        Product product =productService.findById(id);

        if(product == null) return "index";

        model.addAttribute("product", product);
        return  "product/deteilpage";
    }
}
