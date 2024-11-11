package com.example.demo.JPA.Repository.User;

import com.example.demo.Entity.user.QUser;
import com.example.demo.Entity.user.User;
import com.example.demo.Entity.user.dto.request.UserAdminPageRequestDto;
import com.example.demo.Entity.user.dto.response.UserProfileDto;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.example.demo.Entity.user.QUser.user;
import static org.springframework.util.StringUtils.hasText;

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

    @Override
    public Page<UserProfileDto> getAdminUsersPage(UserAdminPageRequestDto pageRequestDto, Pageable pageable){

        QUser user = QUser.user;

        List<UserProfileDto> content = queryFactory
                .select(Projections.fields(UserProfileDto.class,
                        user.userId,
                        user.username,
                        user.email,
                        user.imageUrL,
                        user.phone,
                        user.infoAgreement,
                        user.role))
                .from(user)
                .where(nicknameEq(pageRequestDto.getKeyword()))
                .orderBy()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        JPAQuery<Long> countQuery = queryFactory
                .select(user.count())
                .from(user);

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    private BooleanExpression nicknameEq(String nickname) {
        return hasText(nickname) ? user.username.eq(nickname) : null;
    }

    private OrderSpecifier[] createOrderSpecifier(OrderCondition orderCondition) {

        List<OrderSpecifier> orderSpecifiers = new ArrayList<>();

        if(Objects.isNull(orderCondition)){
            orderSpecifiers.add(new OrderSpecifier(Order.DESC, user.username));
        }else if(orderCondition.equals("latest")){
            orderSpecifiers.add(new OrderSpecifier(Order.DESC, person.age));
        }else {//
            orderSpecifiers.add(new OrderSpecifier(Order.DESC, user.));
        }
        return orderSpecifiers.toArray(new OrderSpecifier[orderSpecifiers.size()]);
    }

}
