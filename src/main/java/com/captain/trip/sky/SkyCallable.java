package com.captain.trip.sky;

import com.captain.model.sky.QuoteResponse;

import java.util.concurrent.Callable;

public class SkyCallable implements Callable<QuoteResponse> {

    private SkyScanner skyScanner;

    @Override
    public QuoteResponse call() throws Exception {
        return new QuoteResponse();
    }
}