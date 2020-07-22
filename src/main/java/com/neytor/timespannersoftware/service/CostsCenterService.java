package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.CostsCenterEntity;

import java.util.List;
import java.util.Optional;

public interface CostsCenterService {
    List<CostsCenterEntity> findAll();

    Optional<CostsCenterEntity> findById(Long id);

    Optional<CostsCenterEntity> findByCode(String code);

    List<CostsCenterEntity> findByCodeContaining(String code);

    List<CostsCenterEntity> findByDescriptionContaining(String description);

    CostsCenterEntity create(CostsCenterEntity costsCenter);

    CostsCenterEntity update(CostsCenterEntity costsCenter);

    void delete(Long id);

    Boolean existsById(Long id);
}
