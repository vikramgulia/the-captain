package com.captain.model.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request {
    private Passengers passengers;
    private List<Slice> slice;
    private String maxPrice;
    private String saleCountry;
    private String ticketingCountry;
    private boolean refundable;
    private int solutions;

    public Request() {
    }

    @Builder
    public Request(Passengers passengers, List<Slice> slice, String maxPrice, String saleCountry, String ticketingCountry, boolean refundable, int solutions) {
        this.passengers = passengers;
        this.slice = slice;
        this.maxPrice = maxPrice;
        this.saleCountry = saleCountry;
        this.ticketingCountry = ticketingCountry;
        this.refundable = refundable;
        this.solutions = solutions;
    }

    public Passengers getPassengers() {
        return passengers;
    }

    public void setPassengers(Passengers passengers) {
        this.passengers = passengers;
    }

    public List<Slice> getSlice() {
        return slice;
    }

    public void setSlice(List<Slice> slice) {
        this.slice = slice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getSaleCountry() {
        return saleCountry;
    }

    public void setSaleCountry(String saleCountry) {
        this.saleCountry = saleCountry;
    }

    public String getTicketingCountry() {
        return ticketingCountry;
    }

    public void setTicketingCountry(String ticketingCountry) {
        this.ticketingCountry = ticketingCountry;
    }

    public boolean isRefundable() {
        return refundable;
    }

    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }

    public int getSolutions() {
        return solutions;
    }

    public void setSolutions(int solutions) {
        this.solutions = solutions;
    }
}