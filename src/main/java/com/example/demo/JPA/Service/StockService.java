package com.example.demo.JPA.Service;

import com.example.demo.JPA.Entity.Product;
import com.example.demo.JPA.Entity.Stock;
import com.example.demo.JPA.Entity.composite.StockPK;
import com.example.demo.JPA.Repository.StockRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public void save(Product product , List<String> sizes, List<String> colors, List<Integer> quantitys){

        for(int i =0; i<colors.size(); i++) {

            StockPK stockPK = StockPK.builder()
                    .product_code(product.getProductId())
                    .size(sizes.get(i))
                    .color(colors.get(i))
                    .build();

            Stock stock = Stock.builder()
                    .stockPK(stockPK)
                    .quantity(quantitys.get(i))
                    .created_time(LocalDateTime.now())
                    .product(product)
                    .build();

            stockRepository.save(stock);
        }

    }


}
