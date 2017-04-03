package com.captain.model.trip.sky;

import com.fasterxml.jackson.annotation.*;
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

    @JsonGetter(value = "Locales")
    public List<com.captain.model.trip.sky.Locales> getLocales() {
        return Locales;
    }

    @JsonSetter(value = "Locales")
    public void setLocales(List<com.captain.model.trip.sky.Locales> locales) {
        Locales = locales;
    }
}
