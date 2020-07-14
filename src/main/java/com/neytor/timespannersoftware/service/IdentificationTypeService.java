package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.IdentificationTypeEntity;

import java.util.List;
import java.util.Optional;

public interface IdentificationTypeService {
    List<IdentificationTypeEntity> findAll();

    Optional<IdentificationTypeEntity> findById(Long id);

    Optional<IdentificationTypeEntity> findByCode(String code);

    Optional<IdentificationTypeEntity> findByDescription(String description);

    Optional<IdentificationTypeEntity> findByShortenedForm(String shortenedForm);

    IdentificationTypeEntity create(IdentificationTypeEntity identificationType);

    IdentificationTypeEntity update(IdentificationTypeEntity identificationType);

    void delete(Long id);

    Boolean existsById(Long id);
}
