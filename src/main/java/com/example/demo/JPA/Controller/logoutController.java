package com.example.demo.JPA.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/logout")
public class logoutController {


    @GetMapping(value={"/logout"})
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login/login";
    }


}
