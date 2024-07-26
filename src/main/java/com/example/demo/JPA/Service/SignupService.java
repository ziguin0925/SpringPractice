package com.example.demo.JPA.Service;

import com.example.demo.JPA.Entity.User;
import com.example.demo.JPA.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class SignupService {

    @Autowired
    private UserRepository userRepository;

    //데이터 베이스에 동일한 아이디가 있는지.
    public boolean idDup(User user) throws Exception {

        //DB에 똑같은 아이디가 없으면 null반환
        User Newuser = userRepository.findById(user.getId()).orElse(null);


        //동일한 아이디를 가진 회원이 있는경우.
        return Newuser != null;

        //동일한 아이디를 가진 회원이 없는경우
    }


    public int signUp(User user) throws Exception {

        try {
            userRepository.save(user);
        } catch(Exception e) {
            return 0;
        }
        return 1;
    }

    public void fistSet(User user) throws Exception{
        user.setUpDate(new Date(System.currentTimeMillis()));
        user.setInDate(new Date(System.currentTimeMillis()));
    }

}
