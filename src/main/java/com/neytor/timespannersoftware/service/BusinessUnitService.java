package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.BusinessUnitEntity;

import java.util.List;
import java.util.Optional;

public interface BusinessUnitService {
    List<BusinessUnitEntity> findAll();

    Optional<BusinessUnitEntity> findById(Long id);

    Optional<BusinessUnitEntity> findByCode(String code);

    List<BusinessUnitEntity> findByCodeContaining(String code);

    List<BusinessUnitEntity> findByDescriptionContaining(String description);

    BusinessUnitEntity create(BusinessUnitEntity BusinessUnit);

    BusinessUnitEntity update(BusinessUnitEntity BusinessUnit);

    void delete(Long id);

    Boolean existsById(Long id);
}
