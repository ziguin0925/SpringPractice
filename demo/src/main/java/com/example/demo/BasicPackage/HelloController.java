package com.example.demo.BasicPackage;

import com.example.demo.JPA.Entity.User;
import com.example.demo.JPA.ServiceEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

// 1. 원격 프로그램으로 등록
@Controller
public class HelloController {
    private ServiceEx serviceEx;

    @Autowired
    public HelloController(ServiceEx serviceEx) {
        this.serviceEx = serviceEx;
    }
    // 2. URL과 메서드를 연결
    @RequestMapping("/")
    public String main() {

        User user = new User();
        user.setName("akkailao");
        user.setPassword("aaa");
        user.setEmail("fff@aaa.com");
        user.setInDate(new Date());
        user.setUpDate(new Date());

        serviceEx.save(user);
        System.out.println("Hello");
        return "index";
    }
}
