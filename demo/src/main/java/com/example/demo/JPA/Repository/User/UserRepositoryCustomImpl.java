package com.example.demo.JPA.Repository.User;

import com.example.demo.Entity.user.QUser;
import com.example.demo.Entity.user.User;
import com.example.demo.Entity.user.dto.UserProfileDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<User> findByUN(String userName) {
        QUser user = QUser.user;
        return  queryFactory.selectFrom(user)
                .where(user.username.eq(userName))
                .fetch(); //List 반환
    }

    /*
    * 회원 정보 제공
    * */
    @Override
    public Optional<UserProfileDto> findByEmail(String email) {

        QUser user = QUser.user;

        return Optional.ofNullable(queryFactory.from(user)
                .select(Projections.fields(UserProfileDto.class,
                        user.userId, user.username, user.nickname, user.email, user.imageUrL, user.phone, user.infoAgreement))
                .where(user.email.eq(email))
                .fetchOne()); // 하나의 객체 반활
    }



    /*
    * 개인 정보 수정 요청
    *  data : password, imageUrl, phone, email, nickName, infoAgreement, infoReceive
    *   if문으로 null 처리, 유효성 검사로 정의.
    * */

}
