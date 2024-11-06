package com.example.demo.JPA.Repository.User;

import com.example.demo.Entity.user.User;
import com.example.demo.Entity.user.dto.UserProfileDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;




@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
        List<User> findByUN(String userName);

        Optional<UserProfileDto> findByEmail(String email);

        @Query("select u.password from User u where u.email = :email")
        Optional<String> findPasswordByEmail(@Param("email") String email);

}

