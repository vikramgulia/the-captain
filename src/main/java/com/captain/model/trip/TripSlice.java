package com.captain.model.trip;

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
public class TripSlice {
    private String airline;
    private String departFrom;
    private String departFromDescription;
    private String arriveTo;
    private String arriveToDescription;
    private String departAt;
    private String arriveAt;
    private String duration;
    private String price;
}