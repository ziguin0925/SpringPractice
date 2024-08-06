package com.example.demo.JPA.Controller;

import com.example.demo.JPA.Entity.Product;
import com.example.demo.JPA.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/brand")
public class BrandController {

    private final ProductService productService;

    @GetMapping(value = "/{brand_id}")
    public String brandMainPage(@PathVariable int brand_id, Model model) {

        return "brand/brandMainPage";
    }
}
