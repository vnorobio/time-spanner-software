package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.LocationEntity;
import com.neytor.timespannersoftware.model.SpotEntity;

import java.util.List;
import java.util.Optional;

public interface SpotService {

    List<SpotEntity> findAll();
    
    Optional<SpotEntity> findById(Long id);

    Optional<SpotEntity> findByCode(String code);

    List<SpotEntity> findByCodeContains(String code);

    List<SpotEntity>  findByDescriptionContaining(String description);

    List<SpotEntity> findByLocation(LocationEntity entity);

    List<SpotEntity> findByCity(CityEntity entity);

    SpotEntity create(SpotEntity entity);

    SpotEntity update(SpotEntity entity);

    void delete(Long id);

    Boolean existsById(Long id);
}
