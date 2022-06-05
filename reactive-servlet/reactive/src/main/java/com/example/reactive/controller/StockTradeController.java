package com.example.reactive.controller;

import com.example.reactive.domain.StockTrade;
import com.example.reactive.service.StockTradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/trade")
public class StockTradeController {
    
    private static final Logger LOG = LoggerFactory.getLogger(StockTradeController.class);

    private final StockTradeService stockTradeService;

    @GetMapping(
            value    = "/company/{companyName}",
            produces = "application/json")
    Flux<StockTrade> getStockTradeByCompanyName(@PathVariable String companyName) {
        return stockTradeService.getStockTradeByCompanyName(companyName);
    }

    @GetMapping(
            value    = "/user/{userId}",
            produces = "application/json")
    Flux<StockTrade> getStockTradeByUserId(@PathVariable Long userId) {
        return stockTradeService.getStockTradeByUserId(userId);
    }
}
