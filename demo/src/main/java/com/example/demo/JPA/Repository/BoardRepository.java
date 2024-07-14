package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {


    //쿼리 메서드 사용.
    //2개 이상의 쿼리(서브쿼리 포함)를 실행하려면 native 쿼리 사용하라는 듯.
    @Query("SELECT b FROM Board  b")
    List<Board> findfromBoard();


    @Query("SELECT b FROM Board b WHERE b.title =:title AND b.writer=:writer")
    List<Board> findbyTitleAndWriter2( @Param("title")String a,  @Param("writer")String b);

    @Query(value = "SELECT * FROM BOARD", nativeQuery = true)
    List<Board> nativeQuery1();

    @Query(value = "SELECT TITLE, WRITER FROM BOARD", nativeQuery = true)
    List<Object[]> nativeQuery2();


    //아래는 spring date JPA

    //SELECT COUNT(*) FROM BOARD WHERE WRITER = writer;
    int countAllByWriter(String writer);


    //SELECT * FROM BOARD WHERE WRITER = writer;
    List<Board> findByWriter(String writer);


    //SELECT * FROM BOARD WHERE TITLE = title;
    List<Board> findByTitle(String title);


    //SELECT * FROM BOARD WHERE TITLE = title AND WRITER = writer;
    List<Board> findByWriterAndTitle(String writer, String title);


    //DELETE FROM BOARD WHERE WRITER = writer;
    @Transactional
    //삭제의 경우 여러건을 delete할 수 있기 때문에 Transaction처리 필수
    int deleteByWriter(String writer);

}