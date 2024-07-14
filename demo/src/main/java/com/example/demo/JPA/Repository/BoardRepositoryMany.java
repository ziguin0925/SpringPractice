package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.Board;
import com.example.demo.JPA.Entity.BoardMany;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardRepositoryMany extends CrudRepository<BoardMany, Long> {


}