package com.captain.model.trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PermittedDepartureTime {
    private String kind;
    private String earliestTime;
    private String latestTime;

    public PermittedDepartureTime() {
    }

    @Builder
    public PermittedDepartureTime(String kind, String earliestTime, String latestTime) {
        this.kind = kind;
        this.earliestTime = earliestTime;
        this.latestTime = latestTime;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEarliestTime() {
        return earliestTime;
    }

    public void setEarliestTime(String earliestTime) {
        this.earliestTime = earliestTime;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }
}
