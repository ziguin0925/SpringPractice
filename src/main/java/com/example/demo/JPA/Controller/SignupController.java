package com.example.demo.JPA.Controller;

import com.example.demo.JPA.Entity.User;
import com.example.demo.JPA.Service.SignupService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    SignupService ss;
    @Autowired
    private SignupService signupService;

    @GetMapping("/signup")
    public String signupForm() {

        return"signupForm";
    }

    @PostMapping("/signup")
    public String signup(@Valid User user, Model m, HttpServletRequest request
            , BindingResult bindingResult ) throws Exception{


        if(bindingResult.hasErrors()){
            return "signupForm";
        }

        //아이디 중복 체크.
        if(ss.idDup(user)) {
            System.out.println("duplicate user");
            String msg="duplicated Id";
            m.addAttribute("msg",msg);
            return	"signupForm";
        }

        signupService.fistSet(user);

        int count = ss.signUp(user);

        //업데이트 안된 경우.
        if(count==0) {
            String msg = "not correct";
            m.addAttribute("msg", msg);
            return "signupForm";

        }


        System.out.println("user 정보 \n"+user);
        HttpSession session = request.getSession();
        session.setAttribute("id", user.getId());
        session.setAttribute("password", user.getPassword());
//        System.out.println(session.getAttribute("id"));

        return"redirect:/";

    }


}