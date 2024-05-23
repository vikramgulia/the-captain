package com.captain.model.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class TripRequest {
    private String from;
    private String to;
    private Date fromDate;
    private Date toDate;
    private int adults;
    private int child;
    private TripType tripType;
    private String ticketClass;

    @Builder
    public TripRequest(String from, String to, Date fromDate, Date toDate, int adults, int child, TripType tripType, String ticketClass) {
        this.from = from;
        this.to = to;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.adults = adults;
        this.child = child;
        this.tripType = tripType;
        this.ticketClass = ticketClass;
    }

    public TripRequest() {
    }
}