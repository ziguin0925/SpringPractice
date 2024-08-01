package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.BoardReply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardReplyRepository extends JpaRepository<BoardReply, Long> {
    Page<BoardReply> findByBoardmanyId(Long articleId, Pageable pageable);

    List<BoardReply> findByBoardmanyId(Long BoardmanyId);
}
