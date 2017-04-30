package com.captain.controller;

import com.captain.model.dao.Airport;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/captain/airports")
@Api(value = "captain/airports",
        description = "the airports controller",
        tags = "airports")
public class Airports {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final Map<Long, Airport> AIRPORTS = new HashMap<>();

    public Airports() throws IOException {
        List<Airport> airports =
                OBJECT_MAPPER.
                        readValue(
                                this.getClass().getClassLoader().getResourceAsStream("airports.json"),
                                OBJECT_MAPPER.getTypeFactory().constructCollectionType(
                                        List.class, Airport.class));
        airports.parallelStream().forEach(airport -> AIRPORTS.put(airport.getId(), airport));
    }

    /**
     * Controller to serve airports based on certain criteria(s)
     *
     * @param id        airport primary key id
     * @param country   country code of the airport
     * @param region    state/region for the airport
     * @param continent continent airport is in
     * @param search    search string for the airport name
     * @param type      search string for the airport type
     * @param iataCode  iata code of the airport
     * @return {@link List} of {@link Airport}s matching the criteria
     */
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            position = 0,
            value = "findAirports",
            httpMethod = "GET",
            responseContainer = "List",
            response = Airport.class,
            produces = MediaType.APPLICATION_JSON_VALUE,
            notes = "findAirports")
    public ResponseEntity<List<Airport>> findAirports(@RequestParam(value = "id", required = false) Long id,
                                                      @RequestParam(value = "country", required = false) String country,
                                                      @RequestParam(value = "state", required = false) String region,
                                                      @RequestParam(value = "continent", required = false) String continent,
                                                      @RequestParam(value = "search", required = false) String search,
                                                      @RequestParam(value = "type", required = false) String type,
                                                      @RequestParam(value = "iata_code", required = false) String iataCode
    ) throws IOException {
        if (id != null)
            return ResponseEntity.ok(Arrays.asList(AIRPORTS.get(id)));
            // filter for rest of criteria
        else {

            return ResponseEntity.ok()
                    .body(AIRPORTS.entrySet()
                            .parallelStream()
                            .map(entry -> entry.getValue())
                            .filter(airport -> !airport.getIataCode().isEmpty())
                            .filter(airport -> filterValueMatchOrContains(airport.getIataCode(), iataCode, true))
                            .filter(airport -> filterValueMatchOrContains(airport.getIsoCountry(), country, true))
                            .filter(airport -> filterValueMatchOrContains(airport.getName(), search, false))
                            .filter(airport -> filterValueMatchOrContains(airport.getIsoRegion(), region, false))
                            .filter(airport -> filterValueMatchOrContains(airport.getContinent(), continent, false))
                            .filter(airport -> filterValueMatchOrContains(airport.getType(), type, false))
                            .collect(Collectors.toList()));
        }
    }

    /**
     * Utility method to filter certain string values.
     *
     * @param value    value against which check need to be performed
     * @param criteria criteria against which it needs to be done
     * @param match    boolean flag to perform exact match or contains match
     * @return boolean to show if match is true or false
     */
    private boolean filterValueMatchOrContains(String value, String criteria, boolean match) {
        if (value != null && value.contains("providence")) {
            System.out.println("CHICAGO!!!!");
        }
        if (criteria != null) {
            if ((match && value.equalsIgnoreCase(criteria)) || (!match && value.toLowerCase().indexOf(criteria.toLowerCase()) > -1)) {
                return true;
            } else
                return false;
        } else
            return true;
    }
}
