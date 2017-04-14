package com.captain.trip.google;

import com.captain.model.trip.google.Input;
import com.captain.model.trip.google.Itinerary;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.nio.file.Files;

@Service
public class QpxExpress {

    private static final ObjectMapper mapper = new ObjectMapper();

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
        //return restTemplate.postForObject(qpxUrl + qpxKey, input, Itinerary.class);

        return mapper.readValue(Files
                        .readAllLines(new File(ClassLoader.getSystemResource("trip.json").getPath()).toPath())
                        .parallelStream()
                        .reduce((s, s2) -> s + s2)
                        .get(),
                Itinerary.class);

    }

}