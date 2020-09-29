package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.LocationEntity;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    List<LocationEntity> findAll();

    Optional<LocationEntity> findById(Long id);

    Optional<LocationEntity> findByCode(String code);

    List<LocationEntity> findByCodeContaining(String code);

    List<LocationEntity> findByDescriptionContaining(String description);

    LocationEntity create(LocationEntity locationEntity);

    LocationEntity update(LocationEntity locationEntity);

    void delete(Long id);

    Boolean existsById(Long id);
}
