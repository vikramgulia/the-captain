package com.captain.finance;

import org.springframework.stereotype.Component;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class Stocks {

    public Map<String, StockQuote> stock(String str) {
        try {
            Map<String, StockQuote> stockQuoteMap = new HashMap<>();
            Map<String, Stock> stock = YahooFinance.get(str.split(","));

            stock.forEach((k, v) -> stockQuoteMap.put(k, v.getQuote()));

            return stockQuoteMap;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
}