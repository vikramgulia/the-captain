package com.captain.model.sky;

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
public class OutboundLeg {
    @JsonProperty(value = "CarrierIds")
    private List<String> carrierIds;
    @JsonProperty(value = "OriginId")
    private int originId;
    @JsonProperty(value = "DestinationId")
    private int destinationId;
    @JsonProperty(value = "departureDate")
    private String departureDate;
}
