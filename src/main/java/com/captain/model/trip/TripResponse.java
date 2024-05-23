package com.captain.model.trip;

import com.captain.model.sky.QuoteResponse;
import com.captain.model.trip.google.Itinerary;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Builder
public class TripResponse {
    private Provider provider;
    private Itinerary itinerary;
    private QuoteResponse quoteResponse;

    enum Provider {
        QPX,
        SKY;
    }
}