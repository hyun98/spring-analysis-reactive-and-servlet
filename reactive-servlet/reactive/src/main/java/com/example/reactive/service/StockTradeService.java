package com.example.reactive.service;

import com.example.reactive.domain.StockTrade;
import com.example.reactive.repository.StockTradeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockTradeService {

    private static final Logger LOG = LoggerFactory.getLogger(StockTradeService.class);

    private final StockTradeRepository stockTradeRepository;

    public Flux<StockTrade> getStockTradeByCompanyName(String companyName) {
        if(companyName.isBlank()) throw new RuntimeException("Need CompanyName");

        LOG.info("get Stock Trade By Company Name Service, {}", companyName);
        return stockTradeRepository.findByCompanyName(companyName)
                .log()
                .map(s -> s);
    }

    public Flux<StockTrade> getStockTradeByUserId(Long userId) {
        if(userId < 1) throw new RuntimeException("Invalid userId");

        LOG.info("get Stock Trade By userId Service, {}", userId);
        return stockTradeRepository.findByUserId(userId)
                .log()
                .map(s -> s);
    }
}
