package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.BoardMany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepositoryMany extends JpaRepository<BoardMany, Long> {

    @Query("SELECT b FROM BoardMany b WHERE b.title like concat('%', :keyword, '%')")
    Page<BoardMany> findAllbyKeyword(PageRequest of, @Param("keyword") String keyword);
}