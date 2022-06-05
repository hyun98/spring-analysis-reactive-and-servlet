package com.example.reactive.controller;

import com.example.reactive.domain.StockTrade;
import com.example.reactive.service.StockTradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StockTradeController {
    
    private static final Logger LOG = LoggerFactory.getLogger(StockTradeController.class);

    private final StockTradeService stockTradeService;

    @GetMapping(
            value    = "/trade/{companyName}",
            produces = "application/json")
    Flux<StockTrade> getStockTradeByCompanyName(@PathVariable String companyName) {
        return stockTradeService.getStockTradeByCompanyName(companyName);
    }
    
}
