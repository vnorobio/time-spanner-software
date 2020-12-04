package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.dto.City;
import com.neytor.timespannersoftware.model.dto.Country;
import com.neytor.timespannersoftware.model.dto.Estate;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List< City > findAll();

    List<City> findByEstate(Estate dto);

    List<City> findByCountry(Country dto);

    Optional<City> findById(Long id);

    Optional<City> findByCode(String code);

    List<City> findByDescriptionContaining(String description);

    City create(City entity);

    City update(City entity);

    void delete(Long id);

    Boolean existsById(Long id);
}
