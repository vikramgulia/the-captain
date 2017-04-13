package com.captain.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "currency")
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Currency {
    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty(value = "Code")
    private String code;
    @JsonProperty(value = "Symbol")
    private String symbol;
    @JsonProperty(value = "Country")
    private String country;
    @JsonProperty(value = "ThousandsSeparator")
    @Column(name = "thousands_separator")
    private String thousandsSeparator;
    @JsonProperty(value = "DecimalSeparator")
    @Column(name = "decimal_separator")
    private String decimalSeparator;
    @JsonProperty(value = "SymbolOnLeft")
    @Column(name = "symbol_on_left")
    private String symbolOnLeft;
    @JsonProperty(value = "SpaceBetweenAmountAndSymbol")
    @Column(name = "space_between_amount_and_symbol")
    private String spaceBetweenAmountAndSymbol;
    @JsonProperty(value = "RoundingCoefficient")
    @Column(name = "rounding_coefficient")
    private String roundingCoefficient;
    @JsonProperty(value = "DecimalDigits")
    @Column(name = "decimal_digits")
    private String decimalDigits;

    public Currency() {
    }

    @Builder
    public Currency(String code, String symbol, String country, String thousandsSeparator, String decimalSeparator, String symbolOnLeft, String spaceBetweenAmountAndSymbol, String roundingCoefficient, String decimalDigits) {
        this.code = code;
        this.symbol = symbol;
        this.country = country;
        this.thousandsSeparator = thousandsSeparator;
        this.decimalSeparator = decimalSeparator;
        this.symbolOnLeft = symbolOnLeft;
        this.spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol;
        this.roundingCoefficient = roundingCoefficient;
        this.decimalDigits = decimalDigits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getThousandsSeparator() {
        return thousandsSeparator;
    }

    public void setThousandsSeparator(String thousandsSeparator) {
        this.thousandsSeparator = thousandsSeparator;
    }

    public String getDecimalSeparator() {
        return decimalSeparator;
    }

    public void setDecimalSeparator(String decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }

    public String getSymbolOnLeft() {
        return symbolOnLeft;
    }

    public void setSymbolOnLeft(String symbolOnLeft) {
        this.symbolOnLeft = symbolOnLeft;
    }

    public String getSpaceBetweenAmountAndSymbol() {
        return spaceBetweenAmountAndSymbol;
    }

    public void setSpaceBetweenAmountAndSymbol(String spaceBetweenAmountAndSymbol) {
        this.spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol;
    }

    public String getRoundingCoefficient() {
        return roundingCoefficient;
    }

    public void setRoundingCoefficient(String roundingCoefficient) {
        this.roundingCoefficient = roundingCoefficient;
    }

    public String getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(String decimalDigits) {
        this.decimalDigits = decimalDigits;
    }
}
