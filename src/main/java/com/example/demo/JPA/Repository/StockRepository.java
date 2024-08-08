package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.Product;
import com.example.demo.JPA.Entity.Stock;
import com.example.demo.JPA.Entity.composite.StockPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, StockPK> {

    List<Stock> findAllByProduct(Product product);
}
