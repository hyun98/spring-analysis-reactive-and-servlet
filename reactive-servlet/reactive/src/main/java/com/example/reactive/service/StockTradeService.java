package com.example.reactive.service;

import com.example.reactive.domain.StockTrade;
import com.example.reactive.repository.StockTradeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class StockTradeService {

    private static final Logger LOG = LoggerFactory.getLogger(StockTradeService.class);

    private final StockTradeRepository stockTradeRepository;

    public Flux<StockTrade> getStockTradeByCompanyName(String companyName) {
        if(companyName.isBlank()) throw new RuntimeException("Need CompanyName");

        return stockTradeRepository.findByCompanyName(companyName)
                .log()
                .map(s -> s);
    } 
}
