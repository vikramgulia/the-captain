package com.captain.model.trip.sky;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@EqualsAndHashCode
public class LocalesWrapper {

    @JsonProperty(value = "Locales")
    private List<Locales> Locales;

    public LocalesWrapper() {
    }

    @Builder
    public LocalesWrapper(List<Locales> Locales) {
        this.Locales = Locales;
    }
}
