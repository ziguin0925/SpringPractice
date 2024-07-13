package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.Board;
import com.example.demo.JPA.Entity.Cart;
import com.example.demo.JPA.Entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OneToOneTest {

    @Autowired
    private CartRepository boardRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    public EntityManager em;
    @Autowired
    private CartRepository cartRepository;


    @Test
    public void oneToOneTest() {
        Member member = new Member();

        member.setMember_id(1L);
        member.setName("jrw");
        member.setEmail("jrw@gmail.com");
        member.setPassword("jrw");
        memberRepository.save(member);

        Cart cart = new Cart();
        cart.setMember(member);
        cart.setId(123L);
        cartRepository.save(cart);




        cart = cartRepository.findById(cart.getId()).orElse(null);
        assertTrue(cart != null);

        member = memberRepository.findById(member.getMember_id()).orElse(null);
        System.out.println("member.cartID = " + member.getCart().getId());
        assertTrue(member != null);


    }

}