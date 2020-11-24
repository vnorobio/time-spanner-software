package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.dto.IdentificationType;

import java.util.List;
import java.util.Optional;

public interface IdentificationTypeService {
    List<IdentificationType> findAll();

    Optional<IdentificationType> findById(Long id);

    Optional<IdentificationType> findByCode(String code);

    Optional<IdentificationType> findByShortenedForm(String shortenedForm);

    IdentificationType create(IdentificationType identificationType);

    IdentificationType update(IdentificationType identificationType);

    void delete(Long id);

    Boolean existsById(Long id);
}
