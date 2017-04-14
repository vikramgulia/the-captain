package com.captain.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Airport implements Serializable {
    private Long id;
    private String ident;
    private String type;
    private String name;
    private String latitudeDeg;
    private String longitudeDeg;
    private String elevationFt;
    private String continent;
    private String isoCountry;
    private String isoRegion;
    private String municipality;
    private String gpsCode;
    private String iataCode;
    private String localCode;
}
