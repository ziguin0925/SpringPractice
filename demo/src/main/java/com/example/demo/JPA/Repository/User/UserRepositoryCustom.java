package com.example.demo.JPA.Repository.User;

import com.example.demo.Entity.user.User;
import com.example.demo.Entity.user.dto.request.UserAdminPageRequestDto;
import com.example.demo.Entity.user.dto.response.UserProfileDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryCustom {

    List<User> findByUN(String userName);

    Optional<UserProfileDto> findByEmail(String email);

    Page<UserProfileDto> getAdminUsersPage(UserAdminPageRequestDto pageRequestDto, Pageable pageRequest);

}
