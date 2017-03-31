package com.captain.model.trip.sky;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@EqualsAndHashCode
public class Locales {
    @JsonProperty(value = "Code")
    private String Code;
    @JsonProperty(value = "Name")
    private String Name;

    public Locales() {
    }

    @Builder
    public Locales(String code, String name) {
        Code = code;
        Name = name;
    }
}