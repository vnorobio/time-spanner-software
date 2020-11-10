package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
    List<CountryEntity> findByNameContaining( String name);
    Optional<CountryEntity> findByNumericCode(Integer numericCode);
    Optional<CountryEntity> findByAlpha2Code(String alpha2Code);
    Optional<CountryEntity> findByAlpha3Code(String alpha3Code);
}
