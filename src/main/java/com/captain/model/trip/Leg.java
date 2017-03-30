package com.captain.model.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Leg {
    private String kind;
    private String id;
    private String aircraft;
    private String arrivalTime;
    private String departureTime;
    private String origin;
    private String destination;
    private String originTerminal;
    private String destinationTerminal;
    private int duration;
    private String operatingDisclosure;
    private int onTimePerformance;
    private int mileage;
    private String meal;
    private boolean secure;
    private int connectionDuration;
    private boolean changePlane;

    public Leg() {
    }

    @Builder
    public Leg(String kind, String id, String aircraft, String arrivalTime, String departureTime, String origin, String destination, String originTerminal, String destinationTerminal, int duration, String operatingDisclosure, int onTimePerformance, int mileage, String meal, boolean secure, int connectionDuration, boolean changePlane) {
        this.kind = kind;
        this.id = id;
        this.aircraft = aircraft;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.origin = origin;
        this.destination = destination;
        this.originTerminal = originTerminal;
        this.destinationTerminal = destinationTerminal;
        this.duration = duration;
        this.operatingDisclosure = operatingDisclosure;
        this.onTimePerformance = onTimePerformance;
        this.mileage = mileage;
        this.meal = meal;
        this.secure = secure;
        this.connectionDuration = connectionDuration;
        this.changePlane = changePlane;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOriginTerminal() {
        return originTerminal;
    }

    public void setOriginTerminal(String originTerminal) {
        this.originTerminal = originTerminal;
    }

    public String getDestinationTerminal() {
        return destinationTerminal;
    }

    public void setDestinationTerminal(String destinationTerminal) {
        this.destinationTerminal = destinationTerminal;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getOperatingDisclosure() {
        return operatingDisclosure;
    }

    public void setOperatingDisclosure(String operatingDisclosure) {
        this.operatingDisclosure = operatingDisclosure;
    }

    public int getOnTimePerformance() {
        return onTimePerformance;
    }

    public void setOnTimePerformance(int onTimePerformance) {
        this.onTimePerformance = onTimePerformance;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public int getConnectionDuration() {
        return connectionDuration;
    }

    public void setConnectionDuration(int connectionDuration) {
        this.connectionDuration = connectionDuration;
    }

    public boolean isChangePlane() {
        return changePlane;
    }

    public void setChangePlane(boolean changePlane) {
        this.changePlane = changePlane;
    }
}
