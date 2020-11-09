package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.model.dto.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List< City > findAll();

    List<City> findByEstate(EstateEntity entity);

    List<City> findByCountry(CountryEntity entity);

    Optional<City> findById(Long id);

    Optional<City> findByCode(String code);

    List<City> findByCodeContaining(String code);

    List<City> findByDescriptionContaining(String description);

    City create(City entity);

    City update(City entity);

    void delete(Long id);

    Boolean existsById(Long id);
}
