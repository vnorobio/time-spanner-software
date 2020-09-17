package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.TerritorialDivisionEntity;

import java.util.List;
import java.util.Optional;

public interface TerritorialDivisionService {
    List<TerritorialDivisionEntity> findAll();

    Optional<TerritorialDivisionEntity> findById(Long id);

    Optional<TerritorialDivisionEntity> findByCode(String code);

    List<TerritorialDivisionEntity> findByCodeContaining(String code);

    List<TerritorialDivisionEntity> findByDescriptionContaining(String description);

    TerritorialDivisionEntity create(TerritorialDivisionEntity businessUnit);

    TerritorialDivisionEntity update(TerritorialDivisionEntity businessUnit);

    void delete(Long id);

    Boolean existsById(Long id);
}
