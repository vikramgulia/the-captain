package com.captain.repo;

import com.captain.model.dao.Airport;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AirportRepository extends CrudRepository<Airport, Long> {
    @Cacheable("airportsByIataCodes")
    Airport findByIataCode(String iataCode);

    @Cacheable("airportsByCountry")
    List<Airport> findByIsoCountry(String country);

    List<Airport> findByNameContaining(String name);

    @Cacheable("allAirports")
    List<Airport> findAll();
}