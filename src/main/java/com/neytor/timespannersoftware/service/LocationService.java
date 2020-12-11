package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.dto.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    List<Location> findAll();

    Optional<Location> findById(Long id);

    Optional<Location> findByCode(String code);

    List<Location> findByCodeContaining(String code);

    List<Location> findByDescriptionContaining(String description);

    Location create(Location dto);

    Location update(Location dto);

    void delete(Long id);

    Boolean existsById(Long id);
}
