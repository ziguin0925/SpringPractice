package com.example.demo.JPA.Repository.User;

import com.example.demo.Entity.user.Role;
import com.example.demo.Entity.user.User;
import com.example.demo.Entity.user.UserState;
import com.example.demo.Entity.user.dto.UserProfileDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//DataJpaTest 는 뭐하는거지.
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private  UserRepository userRepository;

    private User createOneUser(){
        User user = User.builder()
                .username("정룡우")
                .nickname("jeongRyongWoo")
                .email("jlwoo092513@gmail.com")
                .password("123456")
                .imageUrL("jrw_projectS3/profile/정룡우.img")
                .phone("01030913501")
                .birthDate("000925")
                .ipAddress("127.0.0.1")
                .infoAgreement(Boolean.FALSE)
                .joinDate(LocalDate.now())
                .withdrawalDate(null)
                .userState(UserState.ACTIVE)
                .withdrawalStatus(Boolean.FALSE)
                .role(Role.INVESTOR_ADMIN)
                .build();
        userRepository.save(user);
        return user;
    }

    @Test
    @Transactional
    @DisplayName("TestRepository - queryDsl 확인")
    public void test1(){
        User user = User.builder()
                .email("asdf")
                .username("asdf")
                .password("asdf")
                .build();
        userRepository.save(user);

        List<User> users =userRepository.findByUN("asdf");
        assertTrue(users.size()==1);

        System.out.println(users.getFirst());

    }

    @Test
    @Transactional
    @DisplayName("TestRepository - 사용자 프로필 데이터 제공")
    public void testProfile() throws InterruptedException {
         User user = createOneUser();
        System.out.println(userRepository.findById(1L).get());

        //Email은 jwt나 SecurityContext에서 가져오기
        Optional<UserProfileDto> user1 = userRepository.findByEmail(user.getEmail());
        assertTrue(user1.isPresent());
        System.out.println(user1.get());
    }


    @Test
    @Transactional
    @DisplayName("TestRepository")
    public void testPasswordVerification(){
        /*
            BCryptPasswordEncoder 의 matchers로 확인. - 디코딩 불가 단방향 암호방식
            matchers(java.lang.CharSequence rawPassword, java.lang.String encodePassword)
         */
        User user = createOneUser();
        String encodedPassword =  userRepository.findPasswordByEmail("jlwoo092513@gmail.com").orElseThrow(RuntimeException::new);
        assertTrue(Objects.equals(encodedPassword, user.getPassword()));
        System.out.println(encodedPassword);
    }



    @Test
    @Transactional
    @DisplayName("git branch Test")
    public void testBranch(){
        System.out.println(" = " );

    }


    @Test
    @DisplayName("ATestDto 파일 복붙, 수정, 사용시 merge test ")
    public void testMerge(){
        ATestDto aTestDto = new ATestDto();
        aTestDto.setId(1);
        aTestDto.setUserId(3);
    }

    @Test
    @Transactional
    @DisplayName("TestDtoCreate")
    public void testDtoCreate(){
        ATestDto testDto = new ATestDto();
    }


    @Test
    @Transactional
    @DisplayName("git branch Test")
    public void testBranch(){
        System.out.println(" = " );
    }

}