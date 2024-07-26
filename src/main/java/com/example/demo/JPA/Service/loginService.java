package com.example.demo.JPA.Service;

import com.example.demo.JPA.Entity.User;
import com.example.demo.JPA.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
@Transactional
public class loginService {

    @Autowired
    UserRepository userRepository;
    Calendar cal;



    public boolean logincheck(String id, String pwd) throws Exception {

        User user = userRepository.findById(id).orElse(null);

        if(user == null) return false;

        return user.getPassword().equals(pwd);
    }

}
