package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.EstateEntity;

import java.util.List;
import java.util.Optional;

public interface EstateService {
    List<EstateEntity> findAll();

    List<EstateEntity> findByCountry(CountryEntity entity);

    Optional<EstateEntity> findById(Long id);

    Optional<EstateEntity> findByCode(String code);

    List<EstateEntity> findByCodeContaining(String code);

    List<EstateEntity> findByDescriptionContaining(String description);

    EstateEntity create(EstateEntity entity);

    EstateEntity update(EstateEntity entity);

    void delete(Long id);

    Boolean existsById(Long id);
}
