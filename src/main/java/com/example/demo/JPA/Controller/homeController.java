package com.example.demo.JPA.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.http.HttpRequest;

@Controller
public class homeController {

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model){


        return "index";
    }

}
