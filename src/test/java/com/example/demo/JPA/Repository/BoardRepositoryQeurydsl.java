package com.example.demo.JPA.Repository;
/*
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static com.example.demo.JPA.Entity.QBoard.board;

import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryQeurydsl {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private EntityManager em;
    @Autowired
    private ServletWebServerFactoryAutoConfiguration servletWebServerFactoryAutoConfiguration;

    @BeforeEach
    void setUp() {
        for (int i = 0; i <= 100; i++) {
            Board board = new Board();
            board.setId((long) i);
            board.setTitle("title" + i);
            board.setContent("content" + i);
            board.setWriter("writer" + (i % 5));
            board.setViewCnt((long) (Math.random() * 100));
            board.setInDate(new Date());
            board.setUpDate(new Date());
            boardRepository.save(board);

        }
    }

    @Test
    @Order(1)
    @DisplayName("querydsl 1")
    public void querydslTest1(){
//        QBoard board = QBoard.board;
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        JPAQuery<Board> query = queryFactory.selectFrom(board).where(board.title.eq("title1"));

        List<Board> list = query.fetch();
        list.forEach(System.out::println);

    }

    @Test
    @Order(2)
    @DisplayName("querydsl 2")
    public void querydslTest2(){
        JPAQueryFactory qf = new JPAQueryFactory(em);

        JPAQuery<Tuple> query = qf.select(board.writer, board.viewCnt.sum()).from(board)
//                .where(board.title.notLike("title1%"))
//                .where(board.writer.eq("writer1"))
                .where(board.content.contains("content"))
                .where(board.content.isNotNull())
                .groupBy(board.writer)
                .having(board.viewCnt.sum().gt(1000))
                .orderBy(board.writer.asc())
                .orderBy(board.viewCnt.sum().desc());

        List<Tuple> list =query.fetch();
        list.forEach(System.out::println);

    }

    @Test
    @Order(3)
    @DisplayName("querydsl 3")
    public void querydslTest3(){

        String searchBy = "TC";
        String keyword = "1";
        keyword = "%" + keyword + "%";

        BooleanBuilder builder = new BooleanBuilder();

        //동적으로 조건을 달리함.
        if(searchBy.equalsIgnoreCase("T")){
            builder.and(board.title.like(keyword));
        }else if(searchBy.equalsIgnoreCase("C")){
            builder.and(board.content.like(keyword));
        }else if(searchBy.equalsIgnoreCase("TC")){
            builder.and(board.title.like(keyword)).or(board.content.like(keyword));
        }

        JPAQueryFactory qf = new JPAQueryFactory(em);
        JPAQuery<Board> query = qf.selectFrom(board)
                .where(builder)
                .orderBy(board.upDate.desc());

        List<Board> list = query.fetch();
        list.forEach(System.out::println);

    }
}

*/