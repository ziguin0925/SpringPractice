package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
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
