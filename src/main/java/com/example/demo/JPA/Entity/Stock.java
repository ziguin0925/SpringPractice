package com.example.demo.JPA.Entity;

import com.example.demo.JPA.Entity.composite.StockPK;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="stock")
@NoArgsConstructor
public class Stock {

    @EmbeddedId
    private StockPK stockPK;

    @MapsId("product_code")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_datetime")
    private LocalDateTime create_time;


    @Builder
    public Stock(StockPK stockPK, Product product, int quantity, LocalDateTime created_time) {
        this.stockPK = stockPK;
        this.product = product;
        this.quantity = quantity;
        this.create_time = created_time;
    }
}
