package com.captain.model.sky;

import com.captain.model.dao.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteResponse {

    @JsonProperty(value = "Quotes")
    private List<Quote> quotes;

    @JsonProperty(value = "Places")
    private List<Place> places;

    @JsonProperty(value = "Carriers")
    private List<Carrier> carriers;

    @JsonProperty(value = "Currencies")
    private List<Currency> currencies;

}
