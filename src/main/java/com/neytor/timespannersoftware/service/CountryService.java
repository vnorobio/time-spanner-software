package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.dto.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List< Country > findAll();

    Optional<Country> findById(Long id);

    Optional<Country> findByName(String name);

    Optional<Country> findByNumericCode(Integer numericCode);

    Optional<Country> findByAlpha2Code(String alpha2Code);

    Optional<Country> findByAlpha3Code(String alpha3Code);

    Country create(Country country);

    Country update(Country country);

    void delete(Long id);

    Boolean existsById(Long id);
}
