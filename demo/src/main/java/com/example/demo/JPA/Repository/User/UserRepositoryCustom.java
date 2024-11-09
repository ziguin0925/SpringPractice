package com.example.demo.JPA.Repository.User;

import com.example.demo.Entity.user.User;
import com.example.demo.Entity.user.dto.UserProfileDto;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryCustom {

    List<User> findByUN(String userName);

    Optional<UserProfileDto> findByEmail(String userName);


}
