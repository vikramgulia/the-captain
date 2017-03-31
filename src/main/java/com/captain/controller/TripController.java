package com.captain.controller;

import com.captain.model.trip.google.Input;
import com.captain.model.trip.google.Itinerary;
import com.captain.model.trip.sky.LocalesWrapper;
import com.captain.trip.google.QpxExpress;
import com.captain.trip.sky.SkyScanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/captain")
@Api(value = "captain",
        description = "the trip controller",
        tags = "trip")
public class TripController {

    private QpxExpress qpxExpress;
    private SkyScanner skyScanner;

    @Autowired
    public TripController(
            QpxExpress qpxExpress,
            SkyScanner skyScanner
    ) {
        this.qpxExpress = qpxExpress;
        this.skyScanner = skyScanner;
    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/trip"
    )
    @ApiOperation(
            position = 0,
            value = "showMyOptions",
            httpMethod = "POST",
            response = Itinerary.class,
            produces = MediaType.APPLICATION_JSON_VALUE,
            notes = "showMyOptions")
    public ResponseEntity<Itinerary> showMyOptions(@RequestBody Input input) throws Exception {
        return ResponseEntity.ok(qpxExpress.findTrips(input));
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/locales")
    @ApiOperation(
            position = 1,
            value = "getLocales",
            httpMethod = "GET",
            response = LocalesWrapper.class,
            produces = MediaType.APPLICATION_JSON_VALUE,
            notes = "getLocales")
    public ResponseEntity<LocalesWrapper> getLocales() throws Exception {

        return ResponseEntity.ok(skyScanner.locales());
    }
}
