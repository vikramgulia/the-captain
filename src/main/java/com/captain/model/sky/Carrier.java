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
public class Carrier {

    @JsonProperty(value = "CarrierId")
    private int carrierId;
    @JsonProperty(value = "Name")
    private String name;
}