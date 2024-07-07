package com.example.demo.BasicPackage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 1. 원격 프로그램으로 등록
@Controller
public class HelloController {
    // 2. URL과 메서드를 연결
    @RequestMapping("/")
    public String main() {
        System.out.println("Hello");
        return "index";
    }
}
