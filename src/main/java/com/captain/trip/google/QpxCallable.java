package com.captain.trip.google;

import com.captain.model.trip.TripRequest;
import com.captain.model.trip.google.Itinerary;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class QpxCallable implements Callable<Itinerary> {

    private QpxExpress qpxExpress;
    private TripRequest tripRequest;
    private CountDownLatch latch;

    public QpxCallable(QpxExpress qpxExpress, TripRequest tripRequest, CountDownLatch latch) {
        this.qpxExpress = qpxExpress;
        this.tripRequest = tripRequest;
        this.latch = latch;
    }

    @Override
    public Itinerary call() throws Exception {
        Itinerary itinerary = qpxExpress.trips(tripRequest);
        latch.countDown();
        return itinerary;
    }
}
