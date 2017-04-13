package com.captain.model.sky;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    @JsonProperty(value = "QuoteId")
    private int quoteId;
    @JsonProperty(value = "MinPrice")
    private double minPrice;
    @JsonProperty(value = "Direct")
    private boolean direct;
    @JsonProperty(value = "OutboundLeg")
    private OutboundLeg outboundLeg;
    @JsonProperty(value = "QuoteDateTime")
    private String quoteDateTime;
}