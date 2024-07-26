package com.example.demo.JPA.Controller;

import com.example.demo.JPA.Service.loginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
    @RequestMapping("/login")
    public class loginController {

        @Autowired
        loginService ls;

        @GetMapping("/login")
        public String loginForm(HttpServletRequest request, Model m) {

            HttpSession session = request.getSession();

            System.out.println(session);

            if(session.getAttribute("id")!=null) {


//                String sessionId =(String)session.getAttribute("id");
//                String sessionPassword =(String)session.getAttribute("password");
//                redirectAttribute.addAttribute("id",sessionId );
//                redirectAttribute.addAttribute("password", sessionPassword);
                return"redirect:/";
            }
            session.removeAttribute("id");

            return "loginForm";
        }

        @PostMapping("/login")
        public String login(String id, String password, Model m, HttpServletRequest request) throws Exception{

            boolean check = ls.logincheck(id, password);

            if(!check){
                String msg = "not correct";
                m.addAttribute("msg", msg);
                return "loginForm";
            }

            HttpSession session = request.getSession();

            session.setAttribute("id", id);
            session.setAttribute("password", password);

            m.addAttribute("id",id );
            m.addAttribute("password", password);

            return"redirect:/";
        }

    }

