package com.captain.controller;

import com.captain.finance.Stocks;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yahoofinance.quotes.stock.StockQuote;

import java.util.Map;

@RestController
@RequestMapping(value = "/captain")
@Api(value = "captain",
        description = "the stock controller",
        tags = "stock")
public class StockController {

    private Stocks stocks;

    @Autowired
    public StockController(Stocks stocks) {
        this.stocks = stocks;
    }

    @RequestMapping(
            value = "/stock",
            method = RequestMethod.GET
    )
    @ApiOperation(
            position = 0,
            value = "stock",
            httpMethod = "GET",
            response = Map.class,
            produces = MediaType.TEXT_PLAIN_VALUE,
            notes = "stock")
    public ResponseEntity<Map<String, StockQuote>> stock(
            @RequestParam(value = "stock") String stock
    ) {
        return ResponseEntity.ok(stocks.stock(stock));
    }
}