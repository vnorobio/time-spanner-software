package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.dto.City;
import com.neytor.timespannersoftware.model.dto.Location;
import com.neytor.timespannersoftware.model.dto.Spot;

import java.util.List;
import java.util.Optional;

public interface SpotService {

    List<Spot> findAll();
    
    Optional<Spot> findById(Long id);

    Optional<Spot> findByCode(String code);

    List<Spot> findByCodeContains(String code);

    List<Spot>  findByDescriptionContaining(String description);

    List<Spot> findByLocation(Location dto);

    List<Spot> findByCity(City entity);

    Spot create(Spot entity);

    Spot update(Spot entity);

    void delete(Long id);

    Boolean existsById(Long id);
}
