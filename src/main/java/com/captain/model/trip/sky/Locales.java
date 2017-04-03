package com.captain.model.trip.sky;

import com.fasterxml.jackson.annotation.*;
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

    @JsonGetter("Code")
    public String getCode() {
        return Code;
    }

    @JsonSetter("Code")
    public void setCode(String code) {
        Code = code;
    }

    @JsonGetter("Name")
    public String getName() {
        return Name;
    }

    @JsonSetter("Name")
    public void setName(String name) {
        Name = name;
    }
}