package com.captain.controller;

import com.captain.model.trip.Input;
import com.captain.model.trip.Itinerary;
import com.captain.trip.QpxExpress;
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
@RequestMapping("/captain/trip")
@Api(value = "captain/trip",
        description = "the trip controller",
        tags = "trip")
public class TripController {

    private QpxExpress qpxExpress;

    @Autowired
    public TripController(QpxExpress qpxExpress) {
        this.qpxExpress = qpxExpress;
    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
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
}
