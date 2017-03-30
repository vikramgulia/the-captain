package com.captain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity(name = "airport_codes")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Airport implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String ident;
    private String type;
    private String name;
    @Column(name = "latitude_deg")
    private String latitudeDeg;
    @Column(name = "longitude_deg")
    private String longitudeDeg;
    @Column(name = "elevation_ft")
    private String elevationFt;
    private String continent;
    @Column(name = "iso_country")
    private String isoCountry;
    @Column(name = "iso_region")
    private String isoRegion;
    private String municipality;
    @Column(name = "gps_code")
    private String gpsCode;
    @Column(name = "iata_code")
    private String iataCode;
    @Column(name = "local_code")
    private String localCode;
}
