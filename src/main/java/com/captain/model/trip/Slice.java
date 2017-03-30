package com.captain.model.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Slice {
    private String kind;
    private int duration;
    private List<Segment> segment;
    private String origin;
    private String destination;
    private String date;
    private int maxStops;
    private int maxConnectionDuration;
    private String preferredCabin;
    private PermittedDepartureTime permittedDepartureTime;
    private List<String> permittedCarrier;
    private String alliance;
    private List<String> prohibitedCarrier;

    public Slice() {
    }

    @Builder
    public Slice(String kind, int duration, List<Segment> segment, String origin, String destination, String date, int maxStops, int maxConnectionDuration, String preferredCabin, PermittedDepartureTime permittedDepartureTime, List<String> permittedCarrier, String alliance, List<String> prohibitedCarrier) {
        this.kind = kind;
        this.duration = duration;
        this.segment = segment;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.maxStops = maxStops;
        this.maxConnectionDuration = maxConnectionDuration;
        this.preferredCabin = preferredCabin;
        this.permittedDepartureTime = permittedDepartureTime;
        this.permittedCarrier = permittedCarrier;
        this.alliance = alliance;
        this.prohibitedCarrier = prohibitedCarrier;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Segment> getSegment() {
        return segment;
    }

    public void setSegment(List<Segment> segment) {
        this.segment = segment;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMaxStops() {
        return maxStops;
    }

    public void setMaxStops(int maxStops) {
        this.maxStops = maxStops;
    }

    public int getMaxConnectionDuration() {
        return maxConnectionDuration;
    }

    public void setMaxConnectionDuration(int maxConnectionDuration) {
        this.maxConnectionDuration = maxConnectionDuration;
    }

    public String getPreferredCabin() {
        return preferredCabin;
    }

    public void setPreferredCabin(String preferredCabin) {
        this.preferredCabin = preferredCabin;
    }

    public PermittedDepartureTime getPermittedDepartureTime() {
        return permittedDepartureTime;
    }

    public void setPermittedDepartureTime(PermittedDepartureTime permittedDepartureTime) {
        this.permittedDepartureTime = permittedDepartureTime;
    }

    public List<String> getPermittedCarrier() {
        return permittedCarrier;
    }

    public void setPermittedCarrier(List<String> permittedCarrier) {
        this.permittedCarrier = permittedCarrier;
    }

    public String getAlliance() {
        return alliance;
    }

    public void setAlliance(String alliance) {
        this.alliance = alliance;
    }

    public List<String> getProhibitedCarrier() {
        return prohibitedCarrier;
    }

    public void setProhibitedCarrier(List<String> prohibitedCarrier) {
        this.prohibitedCarrier = prohibitedCarrier;
    }
}
