package com.captain.trip.google;

import com.captain.model.trip.TripRequest;
import com.captain.model.trip.google.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class QpxExpress {

    private static final ObjectMapper mapper = new ObjectMapper();
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    private RestTemplate restTemplate;

    @Value("${qpx.url}")
    private String qpxUrl;

    @Value("${qpx.key}")
    private String qpxKey;

    @Autowired
    public QpxExpress(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Itinerary findTrips(Input input) throws Exception {
        return restTemplate.postForObject(qpxUrl + qpxKey, input, Itinerary.class);

        /*return mapper.readValue(Files
                        .readAllLines(new File(ClassLoader.getSystemResource("trip.json").getPath()).toPath())
                        .parallelStream()
                        .reduce((s, s2) -> s + s2)
                        .get(),
                Itinerary.class);*/

    }

    public Itinerary trips(TripRequest tripRequest) throws Exception {
        return findTrips(Input.builder()
                .request(Request.builder()
                        .passengers(Passengers.builder()
                                .adultCount(tripRequest.getAdults())
                                .childCount(tripRequest.getChild())
                                .build())
                        .slice(Arrays.asList(
                                Slice.builder()
                                        .duration(0)
                                        .origin(tripRequest.getFrom())
                                        .destination(tripRequest.getTo())
                                        .date(sdf.format(tripRequest.getFromDate()))
                                        .maxStops(2).
                                        maxConnectionDuration(0)
                                        .build(),
                                Slice.builder()
                                        .duration(0)
                                        .origin(tripRequest.getTo())
                                        .destination(tripRequest.getFrom())
                                        .date(sdf.format(tripRequest.getToDate()))
                                        .maxStops(2).
                                        maxConnectionDuration(0)
                                        .build()
                        ))
                        .refundable(false)
                        .solutions(50)
                        .build())
                .build());
    }

}