package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.EstateEntity;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<CityEntity> findAll();

    List<CityEntity> findByEstate(EstateEntity entity);

    List<CityEntity> findByCountry(CountryEntity entity);

    Optional<CityEntity> findById(Long id);

    Optional<CityEntity> findByCode(String code);

    List<CityEntity> findByCodeContaining(String code);

    List<CityEntity> findByDescriptionContaining(String description);

    CityEntity create(CityEntity entity);

    CityEntity update(CityEntity entity);

    void delete(Long id);

    Boolean existsById(Long id);
}
