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
public class Place {
    @JsonProperty(value = "PlaceId")
    private Long placeId;
    @JsonProperty(value = "IataCode")
    private String iataCode;
    @JsonProperty(value = "Name")
    private String name;
    @JsonProperty(value = "Type")
    private String type;
    @JsonProperty(value = "SkyscannerCode")
    private String skyscannerCode;
    @JsonProperty(value = "CityName")
    private String cityName;
    @JsonProperty(value = "CityId")
    private String cityId;
    @JsonProperty(value = "CountryName")
    private String countryName;
}
