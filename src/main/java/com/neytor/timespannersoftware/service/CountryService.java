package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.CountryEntity;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<CountryEntity> findAll();

    Optional<CountryEntity> findById(Long id);

    Optional<CountryEntity> findByName(String name);

    Optional<CountryEntity> findByNumericCode(Integer numericCode);

    Optional<CountryEntity> findByAlpha2Code(String alpha2Code);

    Optional<CountryEntity> findByAlpha3Code(String alpha3Code);

    CountryEntity create(CountryEntity country);

    CountryEntity update(CountryEntity country);

    void delete(Long id);

    Boolean existsById(Long id);
}
