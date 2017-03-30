package com.captain.model.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Segment {
    private String kind;
    private int duration;
    private Flight flight;
    private String id;
    private String cabin;
    private String bookingCode;
    private int bookingCodeCount;
    private String marriedSegmentGroup;
    private boolean subjectToGovernmentApproval;
    private List<Leg> leg;
    private int connectionDuration;

    public Segment() {
    }

    @Builder
    public Segment(String kind, int duration, Flight flight, String id, String cabin, String bookingCode, int bookingCodeCount, String marriedSegmentGroup, boolean subjectToGovernmentApproval, List<Leg> leg, int connectionDuration) {
        this.kind = kind;
        this.duration = duration;
        this.flight = flight;
        this.id = id;
        this.cabin = cabin;
        this.bookingCode = bookingCode;
        this.bookingCodeCount = bookingCodeCount;
        this.marriedSegmentGroup = marriedSegmentGroup;
        this.subjectToGovernmentApproval = subjectToGovernmentApproval;
        this.leg = leg;
        this.connectionDuration = connectionDuration;
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

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public int getBookingCodeCount() {
        return bookingCodeCount;
    }

    public void setBookingCodeCount(int bookingCodeCount) {
        this.bookingCodeCount = bookingCodeCount;
    }

    public String getMarriedSegmentGroup() {
        return marriedSegmentGroup;
    }

    public void setMarriedSegmentGroup(String marriedSegmentGroup) {
        this.marriedSegmentGroup = marriedSegmentGroup;
    }

    public boolean isSubjectToGovernmentApproval() {
        return subjectToGovernmentApproval;
    }

    public void setSubjectToGovernmentApproval(boolean subjectToGovernmentApproval) {
        this.subjectToGovernmentApproval = subjectToGovernmentApproval;
    }

    public List<Leg> getLeg() {
        return leg;
    }

    public void setLeg(List<Leg> leg) {
        this.leg = leg;
    }

    public int getConnectionDuration() {
        return connectionDuration;
    }

    public void setConnectionDuration(int connectionDuration) {
        this.connectionDuration = connectionDuration;
    }
}
