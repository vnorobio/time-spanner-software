package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.OperatingCenterEntity;

import java.util.List;
import java.util.Optional;

public interface OperatingCenterService {
    List<OperatingCenterEntity> findAll();

    Optional<OperatingCenterEntity> findById(Long id);

    Optional<OperatingCenterEntity> findByCode(String code);

    List<OperatingCenterEntity> findByCodeContaining(String code);

    List<OperatingCenterEntity> findByDescriptionContaining(String description);

    OperatingCenterEntity create(OperatingCenterEntity operatingCenter);

    OperatingCenterEntity update(OperatingCenterEntity operatingCenter);

    void delete(Long id);

    Boolean existsById(Long id);
}
