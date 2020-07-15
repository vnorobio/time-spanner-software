package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.CompanyEntity;
import com.neytor.timespannersoftware.model.IdentificationEntity;
import com.neytor.timespannersoftware.model.PersonEntity;

import java.util.List;
import java.util.Optional;

public interface IdentificationService {
    List<IdentificationEntity> findAll();

    List<PersonEntity> findByIdentificationNumberContaining(String identificationNumber);

    Optional<IdentificationEntity> findById(Long id);

    Optional<IdentificationEntity> findByIdentificationNumber(String identificationNumber);

    IdentificationEntity create(IdentificationEntity identification);

    IdentificationEntity update(IdentificationEntity identification);

    void delete(Long id);

    Boolean existsById(Long id);
}
