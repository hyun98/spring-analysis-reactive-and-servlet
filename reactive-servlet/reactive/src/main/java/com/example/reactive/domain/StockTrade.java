package com.example.reactive.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "stocktrade")
public class StockTrade {

    @Id
    private Long id;

    private LocalDateTime timeStamp;

    private String companyName;

    private double price;

    private int tradeQuantity;

    private TradeAction tradeAction;

    private Long userId;

    public StockTrade(String companyName, double price, int tradeQuantity, TradeAction tradeAction, Long userId) {
        this.timeStamp = LocalDateTime.now();
        this.companyName = companyName;
        this.price = price;
        this.tradeQuantity = tradeQuantity;
        this.tradeAction = tradeAction;
        this.userId = userId;
    }
}

