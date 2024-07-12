package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.Board;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTest3 {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    public EntityManager em;



    @BeforeEach
    void setUp() {
        for (int i = 1; i <= 100; i++) {
            Board board = new Board();
            board.setId((long)i);
            board.setTitle("title"+i);
            board.setContent("content"+i);
            board.setWriter("writer"+(i%5));
            board.setViewCnt((long)(Math.random()*100));
            board.setInDate(new Date());
            board.setUpDate(new Date());
            boardRepository.save(board);

        }
    }

    @Test
    @Order(1)
    @DisplayName("createQuery로 JPQL 테스트")
    public void createQueryTest() {
        String query = "SELECT b FROM Board b";
        TypedQuery<Board> tQuery =em.createQuery(query, Board.class);
        List<Board> list = tQuery.getResultList();
        System.out.println(list.size());
    }

    @Test
    @Order(2)
    @DisplayName("@Query로 JPQL 테스트")
    public void queryAnnoTest() {
       List<Board> list= boardRepository.findfromBoard();
       System.out.println(list.size());
       assertTrue(list.size()==100);

    }



    @Test
    @Order(3)
    @DisplayName("@Query   (:=)")
    public void queryTest() {
        List<Board> list = boardRepository.findbyTitleAndWriter2("title2","writer2");
        List<Board> list2= boardRepository.findfromBoard();
        System.out.println(list2.size());
        list.forEach(x->System.out.println(x.getViewCnt()));
    }

    @Test
    @Order(4)
    @DisplayName("native query")
    public void nativeQueryTest() {
        List<Board> list = boardRepository.nativeQuery1();
        list.stream().forEach(x->System.out.println(x.getViewCnt()));
        assertTrue(list.size()==100);
    }

    @Test
    @Order(5)
    @DisplayName("native query 커럼을 골라서 가져오는 경우")
    public void nativeQueryTest2() {

        List<Object[]> list = boardRepository.nativeQuery2();
        list.stream().map(x-> Arrays.toString(x)).forEach(x->System.out.println(x));
        assertTrue(list.size()==100);
    }


}
